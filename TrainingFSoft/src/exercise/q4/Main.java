package exercise.q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Town town = new Town();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of family: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("Enter home number of family " + (i+1));
            scanner.nextLine();
            String homeNumber = scanner.nextLine();

            System.out.println("Enter number of person in family " + (i+1));
            int personNum = scanner.nextInt();

            List<Person> persons = new ArrayList<>();
            for (int j = 0; j < personNum; j++) {
                System.out.println("Enter name of person " + (j+1));
                scanner.nextLine();
                String name = scanner.nextLine();

                System.out.println("Enter age of person " + (j+1));
                int age = scanner.nextInt();

                System.out.println("Enter job of person " + (j+1));
                scanner.nextLine();
                String job = scanner.nextLine();

                System.out.println("Enter ID Card Number of person " + (j+1));
                long idCardNum = scanner.nextLong();

                persons.add(new Person(name,age,job,idCardNum));
            }

            town.getFamilies().add(new Family(personNum,homeNumber,persons));
        }

        System.out.println("-------------- Display families in town ---------------");
        for (int i = 0; i < town.getFamilies().size(); i++) {
            System.out.println("Family " + (i+1));
            System.out.println(town.getFamilies().get(i));
            System.out.println();
        }

    }
}
