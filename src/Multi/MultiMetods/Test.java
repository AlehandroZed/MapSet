package Multi.MultiMetods;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processer(countDownLatch, i));
        }
        executorService.shutdown();

        for (int i = 0; i < 3; i++) {
            countDownLatch.countDown();
            Thread.sleep(1000);
        }
        //System.out.println("Latch has been opened, thread main is proceeding");

    }

}

class Processer implements Runnable {

    CountDownLatch countDownLatch;
    int id;

    public Processer(CountDownLatch countDownLatch, int id) {
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + id + " proceeded");
    }
}
