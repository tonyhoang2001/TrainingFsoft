package exercise.q15.entity;

import java.util.List;

public class Department {
    private String departmentName;
    private List<Student> students;

    public Department(String departmentName, List<Student> students) {
        this.departmentName = departmentName;
        this.students = students;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
