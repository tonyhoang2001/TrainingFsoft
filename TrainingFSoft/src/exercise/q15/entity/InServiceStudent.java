package exercise.q15.entity;

import java.time.LocalDate;
import java.util.List;

public class InServiceStudent extends Student{
    private String trainingAddress;

    public InServiceStudent(int id, String name, LocalDate dob, int startYear, double incomeGrade, List<LearningOutcome> learningOutcomes, String type, String trainingAddress) {
        super(id, name, dob, startYear, incomeGrade, learningOutcomes, type);
        this.trainingAddress = trainingAddress;
    }

    public String getTrainingAddress() {
        return trainingAddress;
    }

    public void setTrainingAddress(String trainingAddress) {
        this.trainingAddress = trainingAddress;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name +
                ", dob=" + dob +
                ", startYear=" + startYear +
                ", incomeGrade=" + incomeGrade +
                ", learningOutcomes=" + learningOutcomes +
                ", trainingAddress='" + trainingAddress;
    }
}
