package Multi.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestTwo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 20; i++) {
            executorService.submit(new Ant(i));
        }
        executorService.shutdown();
        System.out.println("All tasks submit");
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

class Ant implements Runnable {
    static int count = 0;
    int id;
    List<Integer> list;

    public Ant(int id) {
        this.id = id;
        this.list = new ArrayList<>();
    }

    @Override
    public void run() {
        synchronized (this) {
            sleep(1000);
            someMetod();
        }
    }

    private void someMetod() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        System.out.println(count++);
        System.out.println("Work " + id + " is completed");
        System.out.println();
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
