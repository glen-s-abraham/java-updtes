package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        Future<Integer> future = es.submit(() -> 3 + 5);
        try {
            System.out.println(future.get(500, TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
    }
}
