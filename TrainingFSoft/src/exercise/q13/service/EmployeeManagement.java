package exercise.q13.service;

import exercise.q13.entity.*;
import exercise.q13.exception.BirthDayException;
import exercise.q13.exception.EmailException;
import exercise.q13.exception.FullNameException;
import exercise.q13.exception.PhoneException;
import exercise.q13.validation.Validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeManagement {
    static Scanner scanner = new Scanner(System.in);
    static Validation validation = new Validation();
    private static List<Employee> employees;

    public EmployeeManagement() {
        this.employees = new ArrayList<>();
    }

//    public static void main(String[] args) {
//        employees = new ArrayList<>();
//        LocalDate date = LocalDate.now();
//        List<Certificate> certificates = new ArrayList<>();
//        employees.add(new Experience(1,"t",date,1234567891,"t@gmail.com",certificates,2,"b"));
//        for (Employee e : employees) {
//            System.out.println(e instanceof Employee);
//        }
//    }

    public void addEmployee() {
        List<Certificate> certificates = new ArrayList<>();

        int id = inputID();
        String name = inputName();
        LocalDate dob = inputDOB();
        long phone = inputPhone();
        String email = inputEmail();

        int numOfCerti = inputNum();
        if (numOfCerti != 0) {
            for (int i = 0; i < numOfCerti; i++) {
                String certiID = inputString("Enter Certificate ID: ", "Certificate ID must not contain special characters! Try again...");
                String certiName = inputString("Enter Certificate Name: ", "Certificate Name must not contain special characters! Try again...");
                String certiRank = inputString("Enter Certificate Rank: ", "Certificate Rank must not contain special characters! Try again...");
                LocalDate certiDate = inputDate("Enter Certificate Date: ");
                certificates.add(new Certificate(certiID, certiName, certiRank, certiDate));
            }
        }

        int choice = getEmployeeType();
        switch (choice) {
            case 1: {
                int expYear = inputExpInYear();
                String skill = inputString("Enter skill: ", "Skill must not contain special characters! Try again...");
                employees.add(new Experience(id, name, dob, phone, email, certificates, expYear, skill));
            }
            ;
            case 2: {
                LocalDate graduationDate = inputDate("Enter Graduation Date: ");
                String graduationRank = inputString("Enter Graduation Rank: ", "Graduation Rank must not contain special characters! Try again...");
                String education = inputString("Enter Education: ", "Education must not contain special characters! Try again...");
                employees.add(new Fresher(id, name, dob, phone, email, certificates, graduationDate, graduationRank, education));
            }
            ;
            case 3: {
                String major = inputString("Enter Major: ", "Major must not contain special characters! Try again...");
                String semester = inputString("Enter Semester: ", "Semester must not contain special characters! Try again...");
                String university = inputString("Enter University: ", "University must not contain special characters! Try again...");
                employees.add(new Intern(id, name, dob, phone, email, certificates, major, semester, university));
            }
        }
        Employee.setEmployeeCount(Employee.getEmployeeCount() + 1);
    }

    public void updateEmployee() {
        int id;

        try {
            System.out.print("Enter ID to update: ");
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("ID must be only integer number.");
            return;
        } finally {
            scanner.nextLine();
        }

        if (!checkIDExist(id)) {
            System.out.println("There is no employee with ID = " + id);
            return;
        }

        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setId(inputID());
                e.setName(inputName());
                e.setBirthDay(inputDOB());
                e.setPhone(inputPhone());
                e.setEmail(inputEmail());

                if (e instanceof Experience) {
                    ((Experience) e).setExpInYear(inputExpInYear());
                    ((Experience) e).setProSkill(inputString("Enter skill: ", "Skill must not contain special characters! Try again..."));
                } else if (e instanceof Fresher) {
                    ((Fresher) e).setGraduationDate(inputDate("Enter Graduation Date: "));
                    ((Fresher) e).setGraduationRank(inputString("Enter Graduation Rank: ", "Graduation Rank must not contain special characters! Try again..."));
                    ((Fresher) e).setEducation(inputString("Enter Education: ", "Education must not contain special characters! Try again..."));
                } else if (e instanceof Intern) {
                    ((Intern) e).setMajor(inputString("Enter Major: ", "Major must not contain special characters! Try again..."));
                    ((Intern) e).setSemester(inputString("Enter Semester: ", "Semester must not contain special characters! Try again..."));
                    ((Intern) e).setUniversity(inputString("Enter University: ", "University must not contain special characters! Try again..."));
                }
            }
        }
        System.out.println("Update successful!");
    }

    public void deleteEmployee() {
        int id;

        try {
            System.out.print("Enter ID to delete: ");
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("ID must be only integer number.");
            return;
        } finally {
            scanner.nextLine();
        }

        if (!checkIDExist(id)) {
            System.out.println("There is no employee with ID = " + id);
            return;
        }

        for (Employee e : employees) {
            if (e.getId() == id) {
                int choice = getDeletionChoice();
                if (choice == 1) {
                    employees.remove(e);
                    Employee.setEmployeeCount(Employee.getEmployeeCount()-1);
                    System.out.println("Delete successful!");
                    return;
                } else {
                    System.out.println("Cancel deletion!");
                    return;
                }
            }
        }
    }

    public void showExperience(){
        List<Employee> list = employees.stream().filter(s -> s instanceof Experience).collect(Collectors.toList());
        if (list.isEmpty()){
            System.out.println("There's no experience.");
            return;
        }
        list.stream().map(e -> (Experience) e).forEach(System.out::println);
    }

    public void showFresher(){
        List<Employee> list = employees.stream().filter(s -> s instanceof Fresher).collect(Collectors.toList());
        if (list.isEmpty()){
            System.out.println("There's no fresher.");
            return;
        }
        list.stream().map(e -> (Fresher) e).forEach(System.out::println);
    }

    public void showIntern(){
        List<Employee> list = employees.stream().filter(s -> s instanceof Intern).collect(Collectors.toList());
        if (list.isEmpty()){
            System.out.println("There's no intern.");
            return;
        }
        list.stream().map(e -> (Intern) e).forEach(System.out::println);
    }
    private boolean checkIDExist(int id) {
        if (employees.stream().filter(e -> e.getId() == id).count() == 0) {
            return false;
        }
        return true;
    }

    private Employee getEmployeeByID(int id) {
        List<Employee> list = employees.stream().filter(s -> s.getId() == id).collect(Collectors.toList());
        return list.get(0);
    }

    private int inputID() {
        while (true) {
            try {
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                if (!checkIDExist(id)) {
                    return id;
                }
                System.out.println("ID is already existed. Try another ID!");
            } catch (Exception e) {
                System.out.println("ID must be only integer number.");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private String inputName() {
        while (true) {
            try {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                if (validation.validateName(name)) {
                    return name;
                }
                throw new FullNameException("Invalid Name! Try again...");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LocalDate inputDOB() {
        while (true) {
            try {
                System.out.print("Enter Birthday (DD/MM/yyyy): ");
                String dob = scanner.nextLine();
                if (validation.validateDate(dob)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate localDate = LocalDate.parse(dob, formatter);
                    return localDate;
                }
                throw new BirthDayException("Wrong format: DD/MM/yyyy! Try again...");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LocalDate inputDate(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String date = scanner.nextLine();
                if (validation.validateDate(date)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate localDate = LocalDate.parse(date, formatter);
                    return localDate;
                }
                throw new Exception("Wrong format: dd/MM/yyyy! Try again...");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private long inputPhone() {
        while (true) {
            try {
                System.out.print("Enter Phone: ");
                String input = scanner.nextLine();
                long phone = 0L;
                try {
                    phone = Long.parseLong(input);
                } catch (Exception e) {
                    System.out.println("Phone must be only number.Try again...");
                    continue;
                }
                if (input.length() == 10 || input.length() == 11) {
                    return phone;
                }
                throw new PhoneException("Invalid phone number: length is 10 or 11! Try again...");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputNum() {
        while (true) {
            try {
                System.out.print("Enter number of certificate: ");
                int num = scanner.nextInt();
                if (num < 0) throw new Exception();
                return num;
            } catch (Exception e) {
                System.out.println("You must enter a number >= 0! Try again...");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private String inputEmail() {
        while (true) {
            try {
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                if (validation.validateEmail(email)) {
                    return email;
                }
                throw new EmailException("Wrong format email: a@b.c! Try again...");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputExpInYear() {
        while (true) {
            try {
                System.out.print("Enter Exp In Year: ");
                int expYear = scanner.nextInt();
                return expYear;
            } catch (Exception e) {
                System.out.println("Year of exp must be only integer number.");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private String inputString(String requiredMsg, String exMsg) {
        while (true) {
            try {
                System.out.print(requiredMsg);
                String skill = scanner.nextLine();
                if (validation.validateNoSpecialChar(skill)) {
                    return skill;
                }
                throw new Exception(exMsg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getChoice() {
        while (true) {
            displayMenu();
            System.out.print("Your choice (1->7): ");
            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 7) {
                    throw new Exception();
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.out.println("Invalid choice! Try again....");
            }
        }
    }

    public void displayMenu() {
        System.out.println("\n------------ Employee Management ------------");
        System.out.println("1. Add new employee.");
        System.out.println("2. Update employee.");
        System.out.println("3. Delete employee.");
        System.out.println("4. Show Experience Employee.");
        System.out.println("5. Show Fresher.");
        System.out.println("6. Show Intern.");
        System.out.println("7. Exit program.");
    }

    public int getEmployeeType() {
        while (true) {
            displayEmployeeType();
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

    public void displayEmployeeType() {
        System.out.println("\n------------ Type of Employee ------------");
        System.out.println("1. Experience.");
        System.out.println("2. Fresher.");
        System.out.println("3. Intern.");
    }

    public int getDeletionChoice() {
        while (true) {
            displayDeletionChoice();
            System.out.print("Your choice (1->2): ");
            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 2) {
                    throw new Exception();
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.out.println("Invalid choice! Try again....");
            }
        }
    }

    public void displayDeletionChoice() {
        System.out.print("\nDO you want to delete? (1. Yes / 2. No): ");
    }

}
