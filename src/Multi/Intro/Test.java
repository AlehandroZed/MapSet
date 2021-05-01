package Multi.Intro;

public class Test {
    public static void main(String[] args) {
//        MyThread thread = new MyThread();
//        thread.start();
//
//        MyThread thread1 = new MyThread();
//        thread1.start();

        Thread thread = new Thread(new Runner());
        thread.start();
        Thread thread1  = new Thread(new Runner());
        thread1.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Hello - " + i + Thread.class);
        }
    }
}
