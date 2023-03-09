package exercise.q3;

public class CandidateB extends Candidate {
    private static final String MATH = "Math";
    private static final String CHEMICAL = "Chemical";
    private static final String BIOLOGY = "Biology";

    public CandidateB(int id, String fullName, String address, String priority) {
        super(id, fullName, address, priority);
    }

    @Override
    public String toString() {
        return "CandidateB{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", priority='" + priority + '\'' +
                ", Subject='" + MATH + " - " + CHEMICAL + " - " + BIOLOGY +
                '}';
    }
}
