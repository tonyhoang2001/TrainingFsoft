package introduction.basic.hashcode;

public class EqualsOperation {
    public static void main(String[] args) {
        Person p1 = new Person(1,"tuan");
        Person p2 = new Person(1,"tuan");

        System.out.println(p1.equals(p2)); // return true
        System.out.println(p1 == p2); // return false

        System.out.println(p1.hashCode()); // 1
        System.out.println(p2.hashCode()); // 1
    }
}

class Person{
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    @Override
//    public int hashCode() {
//        return id;
//    }

    @Override
    public boolean equals(Object o) {
        if(this == null || o == null) return true;
        Person p = (Person) o;
        return id == p.id && name.equals(p.name);
    }
}