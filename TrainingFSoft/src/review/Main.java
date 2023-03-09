package review;

import java.util.function.Supplier;

interface Person<T, U> {
    void abc(int a, int b);
}

public class Main<T> {


    static <T> T getObject(Supplier supplier) {
        return (T) supplier.get();
    }

    public static void main(String[] args) {
//        TreeMap
//        Person p = (a,b) -> System.out.println(Math.pow(a,b));
//        p.abc(2,3);
//        List<Integer> list = new ArrayList<>();
//        long c = list.stream().count();
//
//        int i = 7;
//        Integer b = Integer.valueOf(7);
//
//        Integer d = new Integer(2);
//        int e = d.intValue();

        Foo x = new Foo(10);
        Foo y = new Foo(10);

        modify(x, y);

        System.out.println("X: " + x.num);
        System.out.println("Y: " + y.num);

    }

    public static void modify(Foo x, Foo y) {
        x.num += 1;
        y = new Foo(1);
        y.num++;
    }
}

class Foo {
    public int num;

    public Foo(int num) {
        this.num = num;
    }
}

