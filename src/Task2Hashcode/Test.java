package Task2Hashcode;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person(1,"Bob");
        Person person2 = new Person(1,"Bob");

        Set<Person> set = new HashSet<>();
        Map<Person,Integer> map = new HashMap<>();

        set.add(person1);
        set.add(person2);

        map.put(person1,1);
        map.put(person2,1);

        System.out.println(map);
        System.out.println(set);
    }

}
class Person{
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
