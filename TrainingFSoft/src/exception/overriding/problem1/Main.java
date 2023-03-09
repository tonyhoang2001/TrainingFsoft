package exception.overriding.problem1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        SubClass1 subClass1 = new SubClass1();
//        subClass1.method();

        SubClass2 subClass2 = new SubClass2();
        subClass2.method();

    }
}

class SuperClass {
    void method() {
        System.out.println("Super Class");
    }
}

class SubClass2 extends SuperClass {
    void method() throws ArithmeticException {
        System.out.println("Sub Class 2");
    }
}

class SubClass1 extends SuperClass {
//    void method() throws IOException {
//        System.out.println("Sub Class 1");
//    }
}

//        SubClass1 subClass1 = new SubClass1();
//        subClass1.method();

//        SubClass2 subClass2 = new SubClass2();
//        subClass2.method();