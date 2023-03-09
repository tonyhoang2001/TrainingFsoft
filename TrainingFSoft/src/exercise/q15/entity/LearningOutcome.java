package exercise.q15.entity;

public class LearningOutcome implements Comparable<LearningOutcome> {
    private String semester;
    private double avgGrade;

    public LearningOutcome(String semester, double avgGrade) {
        this.semester = semester;
        this.avgGrade = avgGrade;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public int compareTo(LearningOutcome o) {
        if (this.getAvgGrade() > o.getAvgGrade()) return 1;
        else if (this.getAvgGrade() < o.getAvgGrade()) return -1;
        return 0;
    }
}
