package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadpoolTypes {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        Integer cpuCount = Runtime.getRuntime().availableProcessors();
        ExecutorService es2 = Executors.newFixedThreadPool(cpuCount);

        ExecutorService es3 = Executors.newSingleThreadExecutor();
    }    
}
