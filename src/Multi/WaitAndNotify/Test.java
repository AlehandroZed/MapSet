package Multi.WaitAndNotify;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wn = new WaitAndNotify();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                wn.costumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

 class WaitAndNotify {
    final Object lock = new Object();

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Produce thread started");
            this.wait();
            System.out.println("Produce thread resume");
        }
    }

    public void costumer() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);
        synchronized (this) {
            System.out.println("Waiting for key press");
            scanner.nextLine();
            this.notify();
        }
    }
}
