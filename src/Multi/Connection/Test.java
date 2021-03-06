package Multi.Connection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        Connection connection = Connection.getConnection();

        for (int i = 0; i < 200; i++) {
            executorService.submit(() -> {
                try {
                    connection.work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Connection {
    public static Connection connection = new Connection();
    private int connectionCounter;
    Semaphore semaphore = new Semaphore(10);

    private Connection() {
    }

    public static Connection getConnection() {
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        } finally {
            semaphore.release();
        }
    }

    private void doWork() throws InterruptedException {
        synchronized (this) {
            connectionCounter++;
            System.out.println(connectionCounter);
        }
        Thread.sleep(5000);

        synchronized (this) {
            connectionCounter--;
            System.out.println(connectionCounter);
        }
    }
}

