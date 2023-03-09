package java8.defaultAndStaticMethod;

public class StaticMethod {
    public static void main(String[] args) {
        TestClass1 d = new TestClass1();
        d.square(4);

        // Static method executed
        TestInterface1.show();
    }
}


// A simple Java program to TestClassnstrate static
// methods in java
interface TestInterface1
{
    // abstract method
    public void square (int a);

    // static method
    static void show()
    {
        System.out.println("Static Method Executed");
    }
    static void show1()
    {
        System.out.println("Static Method Executed");
    }
}

class TestClass1 implements TestInterface1
{
    // Implementation of square abstract method
    public void square (int a)
    {
        System.out.println(a*a);
    }
}