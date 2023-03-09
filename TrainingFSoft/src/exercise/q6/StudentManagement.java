package exercise.q6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentManagement {
    Scanner scanner = new Scanner(System.in);
    List<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    void addStudent() {

        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();

            System.out.print("Enter address: ");
            scanner.nextLine();
            String address = scanner.nextLine();

            students.add(new Student(name, age, address));
            System.out.println("Add successful!");
        } catch (Exception e) {
            System.out.println("Occur error!");
        }
    }

    void show20AgeStudents() {
        List<Student> list = students.stream().filter(s -> s.getAge()==20).collect(Collectors.toList());
        if (list.isEmpty()){
            System.out.println("Not found!");
            return;
        }
        list.stream().forEach(System.out::println);
    }

    void showNumOfStudents() {
        long count = students.stream().filter(s -> s.getAge()==23 && s.getAddress().equalsIgnoreCase("DN")).count();
        if (count == 0){
            System.out.println("There's no student!");
            return;
        }
        System.out.println("There's " + count + " students.");
    }

    int getChoice() {
        while (true) {
            displayMenu();
            System.out.print("Your choice (1->4): ");
            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 4) {
                    throw new Exception();
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.out.println("Invalid choice! Try again....");
            }
        }
    }

    void displayMenu(){
        System.out.println("\n------------ Student Management ------------");
        System.out.println("1. Add new student.");
        System.out.println("2. Show students has 20 years old.");
        System.out.println("3. Show the number of students has 23 years old and live in DN.");
        System.out.println("4. Exit program.");
    }

}
