package Task3_Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparator_new {
    public static void main(String[] args) {
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat(55, "Tom"));
        catList.add(new Cat(595, "Bob"));
        catList.add(new Cat(5, "Vaska"));
        catList.add(new Cat(155, "Basya"));

        catList.sort(new CatComparator());
        System.out.println(catList);


    }
}

class CatComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return Integer.compare(o2.getId(), o1.getId());
    }
}

class Cat {
    private int id;
    private String name;

    public Cat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", city='" + name + '\'' +
                "}\n";
    }
}
