package java8.defaultAndStaticMethod;

// A simple program to Test Interface default
// methods in java
interface TestInterface {
    // abstract method
    void square(int a);

    // default method
    default void show() {
        System.out.println("Default Method Executed");
    }
    default void show1() {
        System.out.println("Default Method Executed");
    }
}

class TestClass implements TestInterface {
    // implementation of square abstract method
    public void square(int a) {
        System.out.println(a * a);
    }
}

public class DefaultMethod {
    public static void main(String[] args) {
        TestClass d = new TestClass();
        d.square(4);

        // default method executed
        d.show();
    }
}

