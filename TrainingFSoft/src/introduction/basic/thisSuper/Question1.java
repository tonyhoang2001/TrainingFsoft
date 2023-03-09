package introduction.basic.thisSuper;

public class Question1 {
    public static void main(String[] args) {
        Bike bike = new Bike("Honda");
    }
}

class Vehicle {
    Vehicle() { System.out.println("Vehicle is created."); }
}

class Bike extends Vehicle {
    Bike() { System.out.println("Bike is created."); }

    Bike(String brand)
    {
        super(); // it calls Vehicle(), the parent class
        // constructor of class Bike
//        this();
        System.out.println("Bike brand is " + brand);
    }
}
