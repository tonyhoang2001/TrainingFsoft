package java8.methodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StaticMethodRef {

    // Method 1
    // Static method to compare with name
    public static int compareByName(Person a, Person b)
    {
        return a.getName().compareTo(b.getName());
    }

    // Method 2
    // Static method to compare with age
    public static int compareByAge(Person a, Person b)
    {
        return a.getAge().compareTo(b.getAge());
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("vicky", 24));
        personList.add(new Person("poonam", 25));
        personList.add(new Person("sachin", 19));

        Collections.sort(personList, StaticMethodRef::compareByName);

        System.out.println("Sort by name :");
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);

        Collections.sort(personList, StaticMethodRef::compareByAge);
        System.out.println("Sort by age :");
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);
    }
}

class Person {

    private String name;
    private Integer age;

    // Constructor
    public Person(String name, int age)
    {
        // This keyword refers to current instance itself
        this.name = name;
        this.age = age;
    }

    // Getter-setters
    public Integer getAge() { return age; }
    public String getName() { return name; }
}