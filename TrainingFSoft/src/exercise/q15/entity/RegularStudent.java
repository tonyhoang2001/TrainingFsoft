package exercise.q15.entity;

import java.time.LocalDate;
import java.util.List;

public class RegularStudent extends Student{
    public RegularStudent(int id, String name, LocalDate dob, int startYear, double incomeGrade, List<LearningOutcome> learningOutcomes, String type) {
        super(id, name, dob, startYear, incomeGrade, learningOutcomes, type);
    }
}
