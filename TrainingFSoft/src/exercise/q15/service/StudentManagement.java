package exercise.q15.service;

import exercise.q13.exception.FullNameException;
import exercise.q15.entity.*;
import exercise.q15.validation.Validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class StudentManagement {
    static Scanner scanner = new Scanner(System.in);
    static Validation validation = new Validation();

    static DepartmentManagement departmentManagement = new DepartmentManagement();
    static LearningOutcomeManagement learningOutcomeManagement = new LearningOutcomeManagement();
    static List<Student> students = new ArrayList<>();

    public StudentManagement() {
    }

    public void addStudent() {
        List<Department> departments = departmentManagement.departments;
        if (departmentManagement.departments.isEmpty()) {
            System.out.println("There's no department! You must add new department first.");
            return;
        }
        int id = inputID();
        String name = inputName();
        LocalDate dob = inputDate("Enter DOB: ");
        int startYear = inputStartYear();
        double incomeGrade = inputDouble("Enter income grade: ");
        int numOfSemester = inputNumOfSemester();
        List<LearningOutcome> learningOutcomes = new ArrayList<>();

        if (numOfSemester != 0) {
            for (int i = 0; i < numOfSemester; i++) {
                String semester = inputString("Enter Semester: ", "Semester must not contain special characters!");
                double avgGrade = inputDouble("Enter average grade: ");
                int index = learningOutcomeManagement.getIndexBySemester(semester);
                if (index != -1) {
                    learningOutcomeManagement.learningOutcomes.get(index).setAvgGrade(avgGrade);
                } else {
                    learningOutcomes.add(new LearningOutcome(semester, avgGrade));
                }
            }
        }


        Department department = getDepartment();
        department.setStudents(new ArrayList<>());

        int choice = getStudentType();
        if (choice == 2) {
            String trainingAddress = inputString("Enter training address: ", "Address must not contain special characters!");
            InServiceStudent inServiceStudent = new InServiceStudent(id, name, dob, startYear, incomeGrade, learningOutcomes,
                    "inService", trainingAddress);
            students.add(inServiceStudent);
            department.getStudents().add(inServiceStudent);
            System.out.println("Add student successful!");
            return;
        }

        RegularStudent regularStudent = new RegularStudent(id, name, dob, startYear, incomeGrade, learningOutcomes, "regular");
        students.add(regularStudent);
        department.getStudents().add(regularStudent);
        System.out.println("Add student successful!");
    }

    public void determineRegular() {
        int id;

        try {
            System.out.print("Enter ID: ");
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("ID must be only integer number.");
            return;
        } finally {
            scanner.nextLine();
        }

        if (!checkIDExist(id)) {
            System.out.println("There is no student with ID = " + id);
            return;
        }

        long count = students.stream().filter(s -> s.getId() == id && s instanceof RegularStudent).count();
        if (count == 0) {
            System.out.println("Student with ID = " + id + " is not a regular student!");
            return;
        }
        System.out.println("Student with ID = " + id + " is a regular student!");
    }

    public void getAverageSemester() {
        int id;

        try {
            System.out.print("Enter ID: ");
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("ID must be only integer number.");
            return;
        } finally {
            scanner.nextLine();
        }

        if (!checkIDExist(id)) {
            System.out.println("There is no student with ID = " + id);
            return;
        }

        String semester = inputString("Enter Semester: ", "Semester must not contain special characters!");
        for (Student student : students) {
            if (student.getId() == id) {
                List<LearningOutcome> list = student.getLearningOutcomes().stream().filter(l -> semester.equalsIgnoreCase(l.getSemester())).collect(Collectors.toList());
                if (list.isEmpty()) {
                    System.out.println("There's no learning outcome for Student with ID = " + id + " and Semester: " + semester);
                    return;
                } else {
                    System.out.println("The learning outcome for Student with ID = " + id + " and Semester: " + semester + ": " + list.get(0).getAvgGrade());
                    return;
                }
            }
        }

    }

    public void getTotalOfRegular() {
        long count = students.stream().filter(s -> s instanceof RegularStudent).count();
        if (count == 0) {
            System.out.println("There's no regular student!");
            return;
        }
        System.out.println("There are " + count + " regular students!");
    }

    public void findHighestIncomeGradeStudents() {
        for (Department department : departmentManagement.departments) {
            System.out.println("---------- Department " + department.getDepartmentName() + "----------");
            List<Student> studentList = department.getStudents();
            Optional<Student> optionalStudent = studentList.stream().max(Comparator.comparing(Student::getIncomeGrade));
            if (optionalStudent.isPresent()) {
                System.out.println(optionalStudent.get());
            } else {
                System.out.println("There's no student in this department.");
            }
        }
    }

    public void getInServiceStudentsByTrainingAddress() {

        String trainingAddress = inputString("Enter training address: ", "Address must not contain special characters!");

        for (Department department : departmentManagement.departments) {
            System.out.println("---------- Department " + department.getDepartmentName() + "----------");
            List<InServiceStudent> studentList = department.getStudents().stream().filter(s -> s instanceof InServiceStudent).map(s -> (InServiceStudent) s).collect(Collectors.toList());
            List<InServiceStudent> result = studentList.stream().filter(s -> trainingAddress.equals(s.getTrainingAddress())).collect(Collectors.toList());
            if (result.isEmpty()) {
                System.out.println("There's no student with address: " + trainingAddress);
                return;
            } else {
                result.stream().forEach(System.out::println);
            }
        }
    }

    public void getGoodStudents() {
        for (Department department : departmentManagement.departments) {
            System.out.println("---------- Department " + department.getDepartmentName() + "----------");
            List<Student> studentList = department.getStudents();
            List<Student> result = new ArrayList<>();
            Optional<Student> optionalStudent = studentList.stream().max(Comparator.comparing(s -> s.getLearningOutcomes().get(0).getAvgGrade()));

            if (optionalStudent.isPresent()) {
                System.out.println(optionalStudent.get());
            } else {
                System.out.println("There's no student in this department.");
            }
        }
    }

    public void getHighestAvgSemesterStudents() {
        for (Department department : departmentManagement.departments) {
            System.out.println("---------- Department " + department.getDepartmentName() + "----------");
            List<Student> studentList = department.getStudents();

            Map<Integer, LearningOutcome> map = new HashMap<>();

            for (int i = 0; i < studentList.size(); i++) {
                Optional<LearningOutcome> outcome = studentList.get(i).getLearningOutcomes().stream().max(Comparator.comparing(LearningOutcome::getAvgGrade));
                if (outcome.isPresent()) {
                    map.put(i, outcome.get());
                }
            }

            Optional<Map.Entry<Integer, LearningOutcome>> maxEntry = map.entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue));

            if (maxEntry.isPresent()) {
                System.out.println(studentList.get(maxEntry.get().getKey()));
                return;
            }
            System.out.println("There's no student!");
        }
    }

    public void sortByTypeAndStartYear() {
        for (Department department : departmentManagement.departments) {
            System.out.println("---------- Department " + department.getDepartmentName() + "----------");
            List<Student> studentList = department.getStudents();
            if (studentList.isEmpty()) {
                System.out.println("There's no student!");
                return;
            }
            Collections.sort(studentList, new CustomSorting());
            studentList.forEach(System.out::println);
        }
    }

    public void statisticStudents() {
        for (Department department : departmentManagement.departments) {
            System.out.println("---------- Department " + department.getDepartmentName() + "----------");
            List<Student> studentList = department.getStudents();
            Set<Integer> startYears = new TreeSet<>();

            if (studentList.isEmpty()) {
                System.out.println("There's no student!");
                return;
            }

            for (Student student : studentList) {
                startYears.add(student.getStartYear());
            }

            int count[] = new int[startYears.size()];
            int index = 0;

            for (Integer i : startYears) {
                count[index] = 0;
                for (Student student : studentList) {
                    if (student.getStartYear() == i) {
                        count[index]++;
                    }
                }
                System.out.println("Year: " + i + " has " + count[index] + " students.");
                index++;
            }
        }
    }

    public int getChoice() {
        while (true) {
            displayMenu();
            System.out.print("Your choice (1->12): ");
            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 12) {
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
        System.out.println("\n------------ Student Management ------------");
        System.out.println("1. Add new department.");
        System.out.println("2. Add new student.");
        System.out.println("3. Determine student is regular student or not? (by ID).");
        System.out.println("4. Get average semester of a student by given semester.");
        System.out.println("5. Get total of regular student.");
        System.out.println("6. Find students have highest income grade in each department.");
        System.out.println("7. Get list of in-service students by given training address in each department.");
        System.out.println("8. Get list of students have average semester >= 8.0 in the latest semester in each department.");
        System.out.println("9. Get students have highest average semester in any semester in each department.");
        System.out.println("10. Sort students by type in ascending and in descending order by start year in each department.");
        System.out.println("11. Statistic the number of students by start year in each department.");
        System.out.println("12. Exit the program.");
    }

    public int getStudentType() {
        while (true) {
            displayStudentType();
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

    public void displayStudentType() {
        System.out.println("\n------------ Type of student ------------");
        System.out.println("1. Regular student.");
        System.out.println("2. In-Service student.");
    }

    public Department getDepartment() {
        int length = departmentManagement.departments.size();
        while (true) {
            displayDepartment();
            System.out.print("Your choice (1->" + length + "): ");
            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > length) {
                    throw new Exception();
                } else {
                    return departmentManagement.departments.get(choice - 1);
                }
            } catch (Exception e) {
                System.out.println("Invalid choice! Try again....");
            }
        }
    }

    public void displayDepartment() {
        int length = departmentManagement.departments.size();
        System.out.println("\n------------ Type of department ------------");
        for (int i = 0; i < length; i++) {
            System.out.println((i + 1) + ". " + departmentManagement.departments.get(i).getDepartmentName() + ".");
        }
    }

    private boolean checkIDExist(int id) {
        long count = students.stream().filter(s -> s.getId() == id).count();
        if (count == 0) {
            return false;
        }
        return true;
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

    private double inputDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                double grade = 0;

                try {
                    grade = scanner.nextDouble();
                } catch (Exception e) {
                    System.out.println("Invalid grade! Try again...");
                    continue;
                }

                if (grade < 0) throw new Exception();
                return grade;
            } catch (Exception e) {
                System.out.println("Grade must be >= 0! Try again...");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private int inputStartYear() {
        while (true) {
            try {
                System.out.print("Enter start year: ");
                int year = 0;

                try {
                    year = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid year! Try again...");
                    continue;
                }

                if (year > LocalDate.now().getYear()) throw new Exception();
                return year;
            } catch (Exception e) {
                System.out.println("Cannot enter future year! Try again...");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private int inputNumOfSemester() {
        while (true) {
            try {
                System.out.print("How many semesters did student pass? Your input: ");
                int num = 0;

                try {
                    num = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid number! Try again...");
                    continue;
                }

                if (num < 0) throw new Exception();
                return num;
            } catch (Exception e) {
                System.out.println("Your input must be >= 0! Try again...");
            } finally {
                scanner.nextLine();
            }
        }
    }

}
