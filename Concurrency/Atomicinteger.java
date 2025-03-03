package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomicinteger {
    private static AtomicInteger atomiccount = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            es.submit(() -> System.out.println(atomiccount.incrementAndGet() + " "));
        }
        es.shutdown();
    }

}
