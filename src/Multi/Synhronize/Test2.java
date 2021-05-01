package Multi.Synhronize;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.main();
    }
}

class Worker {
    Random random = new Random();

    final Object lock1  = new Object();
    final Object lock2  = new Object();


    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    public  void addToList1() {
        synchronized (lock1) {
            list1.add(random.nextInt(100));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void addToList2() {
        synchronized (lock2) {
            list2.add(random.nextInt(100));
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void work() {
        for (int i = 0; i < 500; i++) {
            addToList1();
            addToList2();
        }
    }


    public void main() {
        long before = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
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

        long after = System.currentTimeMillis();
        System.out.println("Time = " + (after - before));
        System.out.println("list1 : " + list1.size());
        System.out.println("list2 : " + list2.size());
    }
}
