package Multi.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        long before = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Work(i));
        }
        executorService.shutdown();
        System.out.println("all tasks submitted");

        System.out.println(executorService.awaitTermination(1, TimeUnit.DAYS));
        System.out.println("Time: " + (System.currentTimeMillis() - before));
    }
}

class Work implements Runnable {
    // Random random = new Random();
    int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + id + " is completed");
    }
}
