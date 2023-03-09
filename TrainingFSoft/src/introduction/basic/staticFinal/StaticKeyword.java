package introduction.basic.staticFinal;

public class StaticKeyword {
    public static void main(String[] args) {
//        Student s = new Student();
//        System.out.println(s.getAge());
//        s.changeAge();
//
//        Student s1 = new Student();
//        System.out.println(s.getAge());
//        System.out.println(s1.getAge());

//        static {
//            System.out.println("Static block");
//        }

//        Student s = new Student();
//        Student.method1();
//        System.out.println("Main method");

//        Student.StaticClass staticClass = new Student.StaticClass();
//        staticClass.method2();

//        Student.StaticClass.method2();

    }
}

 class Student{
//    private static int i = 9;
     static int age = 3;
     void changeAge(){
        age = 4;
    }
     static int getAge(){
        return age;
    }

    static void method1(){
        System.out.println("Static method");
    }

    static {
        System.out.println("Static block");
    }

    static class StaticClass{
        void method2(){
//            i = 10;
            age = 5;
            System.out.println(getAge());
            System.out.println("Static class");
        }
    }

}