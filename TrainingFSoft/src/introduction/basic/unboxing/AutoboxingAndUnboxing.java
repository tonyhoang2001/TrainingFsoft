package introduction.basic.unboxing;

public class AutoboxingAndUnboxing {
    public static void main(String[] args) {

        // Autoboxing
//        Integer i = new Integer(3);
//        int obj1 = 2;
//        Integer i = obj1;

//        System.out.println("Value of i: " + i);
//        System.out.println("Value of obj1: " + obj1);
//
        // Unboxing
//        int i1 = 5;
        Integer obj2 = new Integer(4);
        int i1 = obj2.intValue();

        System.out.println("Value of i1: " + i1);
        System.out.println("Value of obj2: " + obj2);




        // Creating an empty Arraylist of integer type
//        ArrayList<Integer> list = new ArrayList<Integer>();
////
////        // Adding the int primitives type values
////        // using add() method
////        // Autoboxing
////        list.add(1);
////        list.add(2);
////        list.add(24);
//////
////        // Printing the ArrayList elements
////        System.out.println("ArrayList: " + list);
//
//        // Adding the int primitives type values by
//        //  converting them into Integer wrapper object
//        for (int i = 0; i < 10; i++){
//            System.out.println(
//                    list.add(Integer.valueOf(i)));
//        }



    }
}
