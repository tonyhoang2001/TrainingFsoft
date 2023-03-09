package exercise.q15.service;

import exercise.q15.entity.LearningOutcome;
import exercise.q15.validation.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LearningOutcomeManagement {
    static Scanner scanner = new Scanner(System.in);
    static Validation validation = new Validation();
    static List<LearningOutcome> learningOutcomes = new ArrayList<>();

    public LearningOutcomeManagement() {

    }

    int getIndexBySemester(String semester) {
        for (int i = 0; i < learningOutcomes.size(); i++) {
            if (semester.equalsIgnoreCase(learningOutcomes.get(i).getSemester())) {
                return i;
            }
        }
        return -1;
    }

}
