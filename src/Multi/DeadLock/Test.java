package Multi.DeadLock;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Runner runner = new Runner();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
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

        runner.finish();
    }
}

class Runner {
    private Account account1 = new Account();
    public Account account2 = new Account();


    Random random = new Random();

    public void firstThread() {
        for (int i = 0; i < 100000; i++) {
            Account.transfer(account1, account2, random.nextInt(100));
        }
    }

    public void secondThread() {
        for (int i = 0; i < 100000; i++) {
            Account.transfer(account2, account1, random.nextInt(100));
        }
    }

    public void finish() {
        System.out.println("Account #1 balance: " + account1.getBalance());
        System.out.println("Account #2 balance: " + account2.getBalance());
        System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {
   // private  static ReentrantLock lock = new ReentrantLock();
    Object lock = new Object();
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void wihDraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static synchronized void transfer(Account account1, Account account2, int amount) {

           account1.wihDraw(amount);
           account2.deposit(amount);

    }
}
