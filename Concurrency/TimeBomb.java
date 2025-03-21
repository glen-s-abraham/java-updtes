package Concurrency;

class CountDown implements Runnable {
    String[] timeStrings = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

    @Override
    public void run() {
        for (int i = timeStrings.length - 1; i >= 0; i--) {
            System.out.println(timeStrings[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TimeBomb {
    public static void main(String[] args) throws InterruptedException {
        Thread timer = new Thread(new CountDown());
        System.out.println("Starting 10 seconds count down....");
        timer.start();
        timer.join();
        System.out.println("Boom!!!");
    }

}
