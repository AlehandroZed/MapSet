package Multi.CallableAndFuture;

import java.util.Random;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<Integer> future = executorService.submit(() -> {
            System.out.println("Started");
            Thread.sleep(500);
            System.out.println("Finished");
            Thread.sleep(500);


            Random random = new Random();
            if (random.nextInt(10) < 5) {
                throw new Exception("Thread was interrupted");
            }
            return 333;
        });

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable exception = e.getCause();
            System.out.println(exception.getMessage());
        }

    }
}
