package Multi.ProducerAndCostomer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    costumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void producer() {
        while (true) {
            Random random = new Random();
            blockingQueue.offer(random.nextInt(100));
        }

    }

    public static void costumer() throws InterruptedException {
        while (true) {
            Random random = new Random();
            Thread.sleep(100);
            if (random.nextInt(10) == 5) {
                System.out.println(blockingQueue.take());
                System.out.println("Size is: " + blockingQueue.size());
            }

        }
    }
}
