package test;

public class Main {
    public static void main(String[] args) {

    }
}

class SuperClass{
    //subclass of Exception
    void method() throws CheckedEx {
        System.out.println("Super class");
    }
}

class SubClass1 extends SuperClass{
    //subclass of ClassNotFound
    @Override
    void method() throws CheckedEx
    {
        System.out.println("abc");
    }
}