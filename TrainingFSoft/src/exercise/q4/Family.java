package exercise.q4;

import java.util.List;

public class Family {
    private int personNumber;
    private String homeNumber;
    private List<Person> persons;

    public Family(int personNumber, String homeNumber, List<Person> persons) {
        this.personNumber = personNumber;
        this.homeNumber = homeNumber;
        this.persons = persons;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "personNumber=" + personNumber +
                ", homeNumber='" + homeNumber + '\'' +
                ", persons=" + persons ;
    }
}
