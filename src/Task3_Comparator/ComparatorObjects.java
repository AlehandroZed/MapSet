package Task3_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorObjects {
    public static void main(String[] args) {
        List<Ant> antList = new ArrayList<>();
        antList.add(new Ant(1, "Bob"));
        antList.add(new Ant(5, "Rob"));
        antList.add(new Ant(2, "Cat"));
        antList.add(new Ant(3, "Nik"));

        antList.sort(new Comparator<Ant>() {
            @Override
            public int compare(Ant o1, Ant o2) {
                if (o1.getId() > o2.getId()) {
                    return -1;
                } else if (o1.getId() < o2.getId()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(antList);
    }

}

class Ant {
    int id;
    String name;

    public Ant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
}
