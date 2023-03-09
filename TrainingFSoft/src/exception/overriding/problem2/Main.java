package exception.overriding.problem2;

import javax.security.auth.login.AccountException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.SocketException;
import java.rmi.AccessException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {


//        SubClass1 s1 = new SubClass1();
//        s1.method();

//        SubClass2 s2 = new SubClass2();
//        s2.method();
//
//        SubClass3 s3 = new SubClass3();
//        s3.method();
    }
}


class SuperClass{
    void method() throws IOException {
        System.out.println("Super class");
    }
}

class SubClass1 extends SuperClass{
//    @Override
//    void method() throws ClassNotFoundException
//    {
//        System.out.println("abc");
//    }
}

//class SubClass2 extends SuperClass{
//    @Override
//    void method() throws ArithmeticException {
//        super.method();
//    }
//}
//
//class SubClass3 extends SuperClass{
//    @Override
//    void method() {
//        super.method();
//    }
//}