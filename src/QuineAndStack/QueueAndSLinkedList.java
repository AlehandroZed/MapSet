package QuineAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAndSLinkedList {
    public static void main(String[] args) {

        Ant ant1 = new Ant(1);
        Ant ant2 = new Ant(2);
        Ant ant3 = new Ant(3);
        Ant ant4 = new Ant(4);

        Queue<Ant> antQueue = new LinkedList<>();

        antQueue.add(ant1);
        antQueue.add(ant2);
        antQueue.add(ant3);
        antQueue.add(ant4);

//        for (Ant a: antQueue
//             ) {
//            System.out.println(a);
//        }
        System.out.println(antQueue.remove());
        System.out.println(antQueue.remove());
        System.out.println(antQueue.remove());
        System.out.println(antQueue.remove());
        System.out.println(antQueue.remove());
    }

}

class Ant {
    int id;

    public Ant(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ant{" +
                "id=" + id +
                '}';
    }
}
