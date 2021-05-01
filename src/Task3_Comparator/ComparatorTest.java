package Task3_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Bob");
        list.add("Stefan");
        list.add("Elena");
        list.add("Mike");

        Collections.sort(list, (o1, o2) -> {
            if (o1.length()>o2.length()){
                return 1;
            }else  if (o1.length()<o2.length()){
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println(list);
    }

}
