package model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;
    private Country province;

    public Customer(){}

    public Customer(int id, String name, String email, String address,Country province) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.province = province;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Country getProvince() {
        return province;
    }

    public void setProvince(Country province) {
        this.province = province;
    }
}
