package Concurrency;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new MyThread().start();
        System.out.println(Thread.currentThread().getName());
    }
}
