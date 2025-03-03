package Concurrency;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t = new Thread(new RunnableThread());
        t.start();
        System.out.println(Thread.currentThread().getName());
    }
}
