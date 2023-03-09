package exercise.q13.entity;

import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;

    public Experience(int id, String name, LocalDate birthDay, long phone, String email, List<Certificate> certificates, int expInYear, String proSkill) {
        super(id, name, birthDay, phone, email, certificates);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public double getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public void showInformation() {
        System.out.println("Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", certificates=" + certificates +
                '}');
    }
}
