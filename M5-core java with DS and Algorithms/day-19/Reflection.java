Day_19;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Reflection {

    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;

      
        Method[] methods = personClass.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }

       
        Field[] fields = personClass.getDeclaredFields();
        System.out.println("\nFields:");
        for (Field field : fields) {
            System.out.println(field.getName());
        }

       
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        
        Person person = new Person("John", 30);
        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(person, 35);
        person.printDetails(); 
    }
}
