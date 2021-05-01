package Task1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();


        setTest(hashSet);

        System.out.println(hashSet.contains("Bob"));
        System.out.println(hashSet.size());
    }

    public static void setTest(Set<String> set) {
        set.add("Bob");
        set.add("Rob");
        set.add("Rob");
        set.add("Din");
        set.add("Lin");
        set.add("Soul");
        set.add("Rob");

        System.out.println(set);
//
//        for (String s : set
//        ) {
//            System.out.println(s);
//        }
    }
}
