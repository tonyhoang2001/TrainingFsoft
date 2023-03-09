package exercise.q13.entity;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee{
    private String major;
    private String semester;
    private String university;

    public Intern(int id, String name, LocalDate birthDay, long phone, String email, List<Certificate> certificates, String major, String semester, String university) {
        super(id, name, birthDay, phone, email, certificates);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public void showInformation() {
        System.out.println("Intern{" +
                "major='" + major + '\'' +
                ", semester='" + semester + '\'' +
                ", university='" + university + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", certificates=" + certificates +
                '}');
    }
}
