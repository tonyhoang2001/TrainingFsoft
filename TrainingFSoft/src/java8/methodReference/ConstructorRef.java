package java8.methodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class ConstructorRef {

    // Get List of objects of given
    // length and Supplier
    public static <T> List<T> getObjectList(int length, Supplier<T> objectSupply)
    {
        List<T> list = new ArrayList<>();

        for (int i = 0; i < length; i++)
            list.add(objectSupply.get());
        return list;
    }

    public static void main(String[] args) {
        // Get 10 employee by supplying
        // person supplier, Supplier is
        // created by employee constructor
        // reference
        List<Employee> employeeList
                = getObjectList(5, Employee::new);

        // Print names of employeeList
        employeeList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);
    }
}

class Employee{
    private String name;
    private Integer age;

    // Constructor
    public Employee()
    {
        Random ran = new Random();

        // Assigning a random value
        // to name
        this.name
                = ran
                .ints(97, 122 + 1)
                .limit(7)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    public Integer getAge()
    {
        return age;
    }
    public String getName()
    {
        return name;
    }
}