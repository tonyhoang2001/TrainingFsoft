package exercise.q3;

public class CandidateC extends Candidate {
    private static final String LITERATURE = "Literature";
    private static final String HISTORY = "History";
    private static final String GEOGRAPHY = "Geography";

    public CandidateC(int id, String fullName, String address, String priority) {
        super(id, fullName, address, priority);
    }

    @Override
    public String toString() {
        return "CandidateC{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", priority='" + priority + '\'' +
                ", Subject='" + LITERATURE + " - " + HISTORY + " - " + GEOGRAPHY +
                '}';
    }
}
