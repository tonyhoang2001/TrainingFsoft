package exercise.q4;

import java.util.ArrayList;
import java.util.List;

public class Town {
    private List<Family> families;

    public Town() {
        this.families = new ArrayList<>();
    }

    public List<Family> getFamilies() {
        return families;
    }

    public void setFamilies(List<Family> families) {
        this.families = families;
    }

    @Override
    public String toString() {
        return "Town{" +
                "families=" + families +
                '}';
    }
}
