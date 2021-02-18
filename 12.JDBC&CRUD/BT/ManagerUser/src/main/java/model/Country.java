package model;

public class Country {
    private int countryID;
    private String countryName;
    private String countryCode;

    public Country(){}

    public Country(int countryID) {
        this.countryID = countryID;
    }

    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }

    public Country(int countryID, String countryName, String countryCode) {
        this.countryID = countryID;
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
