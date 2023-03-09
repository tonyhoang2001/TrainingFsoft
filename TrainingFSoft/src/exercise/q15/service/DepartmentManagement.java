package exercise.q15.service;

import exercise.q15.entity.Department;
import exercise.q15.validation.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DepartmentManagement {

    static Scanner scanner = new Scanner(System.in);
    static Validation validation = new Validation();
    static List<Department> departments = new ArrayList<>();

    public DepartmentManagement() {
    }

    public void addDepartment() {
        String name = inputString("Enter department name: ", "Department name must not contain special characters.");
        if (checkExistedDepartment(name)) {
            System.out.println("Department is already existed. Please try another!");
            return;
        }
        departments.add(new Department(name));
        System.out.println("Add department successful!");
    }

    public Department findByName(String name) {
        if (checkExistedDepartment(name)) {
            List<Department> list = departments.stream().filter(d -> name.equalsIgnoreCase(d.getDepartmentName())).collect(Collectors.toList());
            return list.get(0);
        }
        return null;
    }

    private boolean checkExistedDepartment(String name) {
        long count = departments.stream().filter(d -> name.equalsIgnoreCase(d.getDepartmentName())).count();
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

}
