package exercise.q13.entity;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee{
    private LocalDate graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(int id, String name, LocalDate birthDay, long phone, String email, List<Certificate> certificates, LocalDate graduationDate, String graduationRank, String education) {
        super(id, name, birthDay, phone, email, certificates);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void showInformation() {
        System.out.println("Fresher{" +
                "graduationDate=" + graduationDate +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", certificates=" + certificates +
                '}');
    }
}
