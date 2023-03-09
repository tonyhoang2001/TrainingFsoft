package introduction.basic.thisSuper;

public class ThisKeyword {
    // static variable
    static int b = 20;
    // instance variable
    int a = 10;

    public static void main(String[] args) {
// Uncomment this and see here you get
        // Compile Time Error since cannot use
        // 'this' in static context.
//         this.a = 700;
        new ThisKeyword().test();
    }

    void test() {
        // referring current class(i.e, class RR)
        // instance variable(i.e, a)
        this.a = 100;

        System.out.println(a);

        // referring current class(i.e, class RR)
        // static variable(i.e, b)
        this.b = 600;

        System.out.println(b);
    }
}


