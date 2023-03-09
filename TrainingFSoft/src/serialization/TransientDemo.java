package serialization;

import java.io.*;

public class TransientDemo implements Serializable {
    // Use of transient has no impact here
    transient static int l = 40;
    transient final int m = 50;
    // Normal variables
    int i = 10, j = 20;
    // Transient variables
    transient int k = 30;

    public static void main(String[] args) throws Exception {
        TransientDemo input = new TransientDemo();

        // serialization
        FileOutputStream fos = new FileOutputStream("src/serialization/customer.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(input);

        // de-serialization
        FileInputStream fis = new FileInputStream("src/serialization/customer.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TransientDemo output = (TransientDemo) ois.readObject();
        System.out.println("i = " + output.i);
        System.out.println("j = " + output.j);
        System.out.println("k = " + output.k);
        System.out.println("l = " + output.l);
        System.out.println("m = " + output.m);
    }
}
