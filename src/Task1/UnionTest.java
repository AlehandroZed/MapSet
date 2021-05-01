package Task1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UnionTest {
    public static Random random = new Random(49);

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        createSet(set1, 0, 7);
        createSet(set2, 3, 12);

        System.out.println("set1 " + set1);
        System.out.println("set2 " + set2);

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("union " + union);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("intersection " + intersection);

        Set<Integer> subtraction = new HashSet<>(set1);
        subtraction.removeAll(set2);
        System.out.println("subtraction " + subtraction);


    }

    public static void createSet(Set<Integer> set, int n, int m) {
        for (int i = n; i < m; i++) {
            set.add(i);
        }
    }
}
