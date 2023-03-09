package exercise.q4;

public class Person {
    private String name;
    private int age;
    private String job;
    private long IDCardNumber;

    public Person(String name, int age, String job, long IDCardNumber) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.IDCardNumber = IDCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public long getIDCardNumber() {
        return IDCardNumber;
    }

    public void setIDCardNumber(long IDCardNumber) {
        this.IDCardNumber = IDCardNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", IDCardNumber=" + IDCardNumber +
                '}';
    }
}
