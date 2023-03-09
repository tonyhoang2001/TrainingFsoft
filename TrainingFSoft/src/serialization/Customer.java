package serialization;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private  transient String address = "ha noi";
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class Child extends Customer {
    public Child(int id, String name, String address) {
        super(id, name, address);
    }
}