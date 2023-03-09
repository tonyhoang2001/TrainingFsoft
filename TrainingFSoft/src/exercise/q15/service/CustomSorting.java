package exercise.q15.service;

import exercise.q15.entity.Student;

import java.util.Comparator;

public class CustomSorting implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int TypeCompare = o1.getType().compareTo(o2.getType());
        Integer year1 = o1.getStartYear();
        Integer year2 = o2.getStartYear();
        int StartYearCompare = year1.compareTo(year2);

        return (TypeCompare == 0) ?  StartYearCompare : TypeCompare;
    }
}
