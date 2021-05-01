package Task4_Comparable;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Ant> antList = new ArrayList<>();
        Set<Ant> antSet = new TreeSet<>();

        addElements(antList);
        addElements(antSet);

        Collections.sort(antList);

        System.out.println(antList);
        System.out.println(antSet);
    }

    public static void addElements(Collection<Ant> collection) {
        collection.add(new Ant(5, "Bob"));
        collection.add(new Ant(7, "Micky"));
        collection.add(new Ant(2, "Barcelona"));
        collection.add(new Ant(1, "Lena"));
    }
}

class Ant implements Comparable<Ant> {
    private final int id;
    private final String name;

    public Ant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Ant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Ant o) {
       // return Integer.compare(this.id, o.id);
        return  Integer.compare(this.getId(),o.getId());
    }
}
