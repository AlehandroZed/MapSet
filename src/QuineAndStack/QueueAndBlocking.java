package QuineAndStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueAndBlocking {
    public static void main(String[] args) {

        Ant ant1 = new Ant(1);
        Ant ant2 = new Ant(2);
        Ant ant3 = new Ant(3);
        Ant ant4 = new Ant(4);
        Ant ant5 = new Ant(5);

        Queue<Ant> antQueue = new ArrayBlockingQueue<Ant>(3);

        System.out.println( antQueue.offer(ant1));
        System.out.println( antQueue.offer(ant2));
        System.out.println( antQueue.offer(ant3));
        System.out.println( antQueue.offer(ant4));
        System.out.println( antQueue.offer(ant5));

        for (Ant a: antQueue
        ) {
            System.out.println(a);
        }
    }

}

