package exercise.q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Examination {
    List<Candidate> candidates;
    Scanner scanner = new Scanner(System.in);

    public Examination() {
        this.candidates = new ArrayList<>();
    }

    void addCandidate(){
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter full name: ");
        String fullname = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter priority: ");
        String priority = scanner.nextLine();

        int choice = getCandidateType();
        switch (choice){
            case 1:{
                CandidateA candidate = new CandidateA(id,fullname,address,priority);
                this.candidates.add(candidate);
                break;
            }

            case 2:{
                CandidateB candidate = new CandidateB(id,fullname,address,priority);
                this.candidates.add(candidate);
                break;
            }

            case 3:{
                CandidateC candidate = new CandidateC(id,fullname,address,priority);
                this.candidates.add(candidate);
                break;
            }
        }

        System.out.println("Add candidate successful!");
    }

    void showCandidates(){
        if(candidates.isEmpty()){
            System.out.println("Empty!");
            return;
        }
        candidates.stream().forEach(System.out::println);
    }

    void searchByID(){
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        List<Candidate> list = candidates.stream().filter(c -> c.getId() == id).collect(Collectors.toList());

        if (list == null || list.isEmpty()){
            System.out.println("Not found!");
            return;
        }

        Candidate candidate = null;
        for (Candidate c : list) {
            candidate = c;
        }

        System.out.println(candidate);
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

    int getCandidateType() {
        while (true) {
            displayCandidateType();
            System.out.print("Your choice (1->3): ");
            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 3) {
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
        System.out.println("\n------------ Candidate Management ------------");
        System.out.println("1. Add new candidate.");
        System.out.println("2. Show list of candidate.");
        System.out.println("3. Search candidate by id.");
        System.out.println("4. Exit program.");
    }

    void displayCandidateType(){
        System.out.println("\n------------ Kinds of candidate ------------");
        System.out.println("1. Candidate A.");
        System.out.println("2. Candidate B.");
        System.out.println("3. Candidate C.");
    }

}
