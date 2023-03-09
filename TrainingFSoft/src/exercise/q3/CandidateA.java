package exercise.q3;

public class CandidateA extends Candidate {
    private static final String MATH = "Math";
    private static final String CHEMICAL = "Chemical";
    private static final String PHYSICAL = "Physical";

    public CandidateA(int id, String fullName, String address, String priority) {
        super(id, fullName, address, priority);
    }

    @Override
    public String toString() {
        return "CandidateA{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", priority='" + priority + '\'' +
                ", Subject='" + MATH + " - " + CHEMICAL + " - " + PHYSICAL +
                '}';
    }
}
