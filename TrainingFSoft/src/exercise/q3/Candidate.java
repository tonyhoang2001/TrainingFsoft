package exercise.q3;

public class Candidate {
    protected int id;
    protected String fullName;
    protected String address;
    protected String priority;

    public Candidate(int id, String fullName, String address, String priority) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
