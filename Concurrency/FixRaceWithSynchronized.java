package Concurrency;

public class FixRaceWithSynchronized {
    private static Object lock = new Object();
    private static int count = 0;

    // public synchronized static void addCounter() {
    // int c = count;
    // System.out.println("Before. " + count + ". Thread id: " +
    // Thread.currentThread().getId());
    // count = c + 1;
    // System.out.println("After. " + count + ". Thread id: " +
    // Thread.currentThread().getId());
    // }

    // public static void addCounter() {
    // synchronized (FixRaceWithSynchronized.class) {
    // int c = count;
    // System.out.println("Before. " + count + ". Thread id: " +
    // Thread.currentThread().getId());
    // count = c + 1;
    // System.out.println("After. " + count + ". Thread id: " +
    // Thread.currentThread().getId());
    // }
    // }

    // public static void addCounter() {
    // synchronized (lock) {
    // int c = count;
    // System.out.println("Before. " + count + ". Thread id: " +
    // Thread.currentThread().getId());
    // count = c + 1;
    // System.out.println("After. " + count + ". Thread id: " +
    // Thread.currentThread().getId());
    // }
    // }

    public void addCounter() {
        synchronized (this) {
            int c = count;
            System.out.println("Before. " + count + ". Thread id: " +
                    Thread.currentThread().getId());
            count = c + 1;
            System.out.println("After. " + count + ". Thread id: " +
                    Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        FixRaceWithSynchronized f = new FixRaceWithSynchronized();
        for (int i = 1; i <= 10; i++) {
            // new Thread(() -> addCounter()).start();
            new Thread(() -> f.addCounter()).start();
        }
    }
}
