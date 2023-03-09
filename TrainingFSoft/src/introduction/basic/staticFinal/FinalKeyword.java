package introduction.basic.staticFinal;

public class FinalKeyword {
    public static void main(String[] args) {

    }
}

class Parent{
    static final int I;

    static {
        I = 9;
    }

    Parent(int i) {
//        this.I = i;
    }

    final void methodA(){
//        i = 1;
    }
}

//class Child extends Parent{
////    Child() {
////        super(i);
//    }
////    void methodA(){}
//}

final class FinalParent{}

//class FinalChild extends FinalParent{}