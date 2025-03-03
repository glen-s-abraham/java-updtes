package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixRaceWithLock {
    private static int count = 0;
    private static Lock lock = new ReentrantLock();

    public static void addCounter() {
        try {
            lock.lock();
            int c = count;
            System.out.println("Before. " + count + ". Thread id: " + Thread.currentThread().getId());
            count = c + 1;
            System.out.println("After. " + count + ". Thread id: " + Thread.currentThread().getId());
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> addCounter()).start();
            ;
        }
    }
}
