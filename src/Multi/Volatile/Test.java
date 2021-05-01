package Multi.Volatile;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        thread.shutDown();
    }
}

class MyThread extends Thread {
    private volatile boolean  runner = true;

    @Override
    public void run() {

        int i = 0;
        while (runner) {
            System.out.println("i am working - " + i);
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        runner = false;
    }
}
