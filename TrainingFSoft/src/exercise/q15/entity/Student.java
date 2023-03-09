package exercise.q15.entity;

import java.time.LocalDate;
import java.util.List;

public class Student {
    protected int id;
    protected String name;
    protected LocalDate dob;
    protected int startYear;
    protected double incomeGrade;
    protected List<LearningOutcome> learningOutcomes;
    protected String type;

    public Student(int id, String name, LocalDate dob, int startYear, double incomeGrade, List<LearningOutcome> learningOutcomes, String type) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.startYear = startYear;
        this.incomeGrade = incomeGrade;
        this.learningOutcomes = learningOutcomes;
        this.type = type;
    }

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public double getIncomeGrade() {
        return incomeGrade;
    }

    public void setIncomeGrade(double incomeGrade) {
        this.incomeGrade = incomeGrade;
    }

    public List<LearningOutcome> getLearningOutcomes() {
        return learningOutcomes;
    }

    public void setLearningOutcomes(List<LearningOutcome> learningOutcomes) {
        this.learningOutcomes = learningOutcomes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", startYear=" + startYear +
                ", incomeGrade=" + incomeGrade +
                ", learningOutcomes=" + learningOutcomes;
    }
}
