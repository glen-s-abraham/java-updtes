package Concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutors {
    public static ScheduledExecutorService schedEs = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
        // schedule();
        // scheduleWithFixedDelay();
        scheduleWithFixedRate();
    }

    public static void schedule() {
        System.out.println("Start..");
        Future<String> future = schedEs.schedule(() -> "A", 2, TimeUnit.SECONDS);
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            schedEs.shutdown();
        }
        System.out.println("Always at the end");
    }

    public static void scheduleWithFixedDelay() {
        System.out.println("Start..");
        final long INITIAL_DELAY = 2000, WAIT_PERIOD_AFTER_PREV_TASK_FINISHED = 300;
        schedEs.scheduleWithFixedDelay(() -> System.out.println("Thread id: " + Thread.currentThread().getId()),
                INITIAL_DELAY, WAIT_PERIOD_AFTER_PREV_TASK_FINISHED, TimeUnit.MILLISECONDS);

    }

    public static void scheduleWithFixedRate() {
        System.out.println("Start..");
        final long INITIAL_DELAY = 2000, WAIT_PERIOD_AFTER_PREV_TASK_FINISHED = 300;
        schedEs.scheduleAtFixedRate(() -> System.out.println("Thread id: " + Thread.currentThread().getId()),
                INITIAL_DELAY, WAIT_PERIOD_AFTER_PREV_TASK_FINISHED, TimeUnit.MILLISECONDS);

    }

}
