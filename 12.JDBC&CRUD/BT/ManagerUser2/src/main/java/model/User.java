package model;

public class User {
    private int id;
    private String name;
    private String email;
    Country country;

    public User(){}

    public User(int id, String name, String email, Country country_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country_id;
    }

    public User(String name, String email, Country country_id) {
        this.name = name;
        this.email = email;
        this.country = country_id;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
