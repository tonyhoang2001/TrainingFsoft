package exercise.q13.entity;

import java.time.LocalDate;
import java.util.List;

public abstract class Employee {
    protected int id;
    protected String name;
    protected LocalDate birthDay;
    protected long phone;
    protected String email;
    protected List<Certificate> certificates;
    protected static long employeeCount = 0;

    public Employee(int id, String name, LocalDate birthDay, long phone, String email, List<Certificate> certificates) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.certificates = certificates;
    }

    public abstract void showInformation();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public static long getEmployeeCount() {
        return employeeCount;
    }

    public static void setEmployeeCount(long employeeCount) {
        Employee.employeeCount = employeeCount;
    }
}
