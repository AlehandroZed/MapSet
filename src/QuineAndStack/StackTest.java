package QuineAndStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Ant> antStack = new Stack<>();

        Ant ant1 = new Ant(1);
        Ant ant2 = new Ant(2);
        Ant ant3 = new Ant(3);
        Ant ant4 = new Ant(4);

        antStack.push(ant1);
        antStack.push(ant2);
        antStack.push(ant3);
        antStack.push(ant4);



        while (!antStack.empty()){
            System.out.println(antStack.pop());
        }
    }
}
