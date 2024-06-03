Day-19;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Person2 {
    String name;
    int age;

    Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class FunctionalInterface {

    public static void processPerson(Person2 person, Predicate<Person2> predicate,
                                     Function<Person2, String> function, Consumer<String> consumer,
                                     Supplier<Person2> supplier) {

        if (predicate.test(person)) {
            String result = function.apply(person);
            consumer.accept(result);
        }

        Person2 newPerson = supplier.get();
        System.out.println("New Person: " + newPerson);
    }

    public static void main(String[] args) {
        Person2 person = new Person2("Alice", 30);

        Predicate<Person2> agePredicate = p -> p.age > 25;
        Function<Person2, String> nameFunction = p -> "Name: " + p.name;
        Consumer<String> printConsumer = System.out::println;
        Supplier<Person2> personSupplier = () -> new Person2("Bob", 40);

        processPerson(person, agePredicate, nameFunction, printConsumer, personSupplier);
    }
}


