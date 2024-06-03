Day_19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person1 {
    String name;
    int age;

    Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class Lambda {

    public static void main(String[] args) {
        List<Person1> people = new ArrayList<>();
        people.add(new Person1("Alice", 34));
        people.add(new Person1("Bob", 25));
        people.add(new Person1("Charlie", 29));

        people.sort(Comparator.comparingInt(p -> p.age));

        people.forEach(System.out::println);
    }
}

