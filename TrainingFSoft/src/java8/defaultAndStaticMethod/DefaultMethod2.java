package java8.defaultAndStaticMethod;

public class DefaultMethod2 {
    public static void main(String[] args) {
        TestClass2 d = new TestClass2();
        d.show();
    }
}

interface TestInterface2
{
    // default method
    default void show()
    {
        System.out.println("Default TestInterface2");
    }
}

interface TestInterface3
{
    // Default method
    default void show()
    {
        System.out.println("Default TestInterface3");
    }

    static void a(){}

}

class TestClass2 implements TestInterface2, TestInterface3
{
    // Overriding default show method
    public void show()
    {
        // use super keyword to call the show
        // method of TestInterface1 interface
//        super.show();

        // use super keyword to call the show
        // method of TestInterface2 interface
//        TestInterface3.super.show();
    }
}