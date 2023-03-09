package serialization;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/serialization/customer.txt"));
        Customer customer = new Customer(1,"tuan");
//        Company company = new Company(customer);

//        Child child = new Child(1,"tuan","bac giang");

//        System.out.println("Company before serialization:");
//        System.out.println(company);
//        oos.writeObject(company);

        System.out.println("Customer before serialization:");
        System.out.println(customer);
        oos.writeObject(customer);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/serialization/customer.txt"));
        Customer customerInp = null;
        customerInp = (Customer) ois.readObject();
        System.out.println(customerInp);

    }
}


