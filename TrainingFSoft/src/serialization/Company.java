package serialization;

import java.io.Serializable;

public class Company implements Serializable {
    Customer customer;

    public Company(Customer customer) {
        this.customer = customer;
    }
}
