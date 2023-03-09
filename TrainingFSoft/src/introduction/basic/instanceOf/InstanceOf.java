package introduction.basic.instanceOf;

public class InstanceOf {
    public static void main(String[] args) {
        // Creating object of child class
//        Child cobj = new Child();
//
//        // A simple case
//        if (cobj instanceof Child)
//            System.out.println("cobj is instance of Child");
//        else
//            System.out.println(
//                    "cobj is NOT instance of Child");
//
//        // instanceof returning true for Parent class also
//        if (cobj instanceof Parent)
//            System.out.println(
//                    "cobj is instance of Parent");
//        else
//            System.out.println(
//                    "cobj is NOT instance of Parent");
//
//        // instanceof returns true for all ancestors
//
//        // Note : Object is ancestor of all classes in Java
//        if (cobj instanceof Object)
//            System.out.println(
//                    "cobj is instance of Object");
//        else
//            System.out.println(
//                    "cobj is NOT instance of Object");

        //-------------------------------------------------------
//        Child obj = null;
//        // A simple case
//        if (obj instanceof Child)
//            System.out.println("obj is instance of Child");
//        else
//            System.out.println("obj is NOT instance of Child");


        //-------------------------------------------------------
//        Parent pobj = new Parent();
//        if (pobj instanceof Child)
//            System.out.println("pobj is instance of Child");
//        else
//            System.out.println("pobj is NOT instance of Child");

        //-------------------------------------------------------
        // Reference is Parent type but object is
        // of child type.
        Parent obj1 = new Child();
        if (obj1 instanceof Child)
            System.out.println("obj1 is instance of Child");
        else
            System.out.println("obj1 is NOT instance of Child");

        if (obj1 instanceof Parent) {
            System.out.println("obj1 is instance of Parent");
        }

        //-------------------------------------------------------
//        Parent cobj = new Parent();
//        Parent par = cobj;
//
//        // Using instanceof to make sure that par
//        // is a valid reference before typecasting
//        if (par instanceof Child)
//        {
//            System.out.println("Value accessed through " +
//                    "parent reference with typecasting is " +
//                    ((Child)par).value);
//        }

    }
}

// Parent class
class Parent {int value = 1000;}

// Child class
class Child extends Parent {
    int value = 10;
}