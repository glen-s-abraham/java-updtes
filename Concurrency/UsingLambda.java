package Concurrency;

public class UsingLambda {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        t.start();
        // t.run(); //execute in current thread.
        System.out.println(Thread.currentThread().getName());
    }
}
