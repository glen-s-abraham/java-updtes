package Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmittingTaskCollections {
    private static ExecutorService es = Executors.newSingleThreadExecutor();
    // private static ExecutorService es = Executors.newFixedThreadPool(4);
    private static List<Callable<String>> callables = new ArrayList<>();

    public static void main(String[] args) {
        callables.add(() -> "A");
        callables.add(() -> "B");
        callables.add(() -> "C");
        callables.add(() -> "D");

        // invokeAny();
        invokeAll();

    }

    public static void invokeAny() {
        try {
            // A single thread executor will always execute the first task submitted.
            String result = es.invokeAny(callables);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
    }

    public static void invokeAll() {
        try {
            List<Future<String>> futures = es.invokeAll(callables);
            for (Future<String> future : futures) {
                System.out.println("Future: " + future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
