package service;

import model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryService {
    static List<Country> countries;
    static {
        countries = new ArrayList<>();
        countries.add(new Country(1,"province1"));
        countries.add(new Country(2,"province2"));
        countries.add(new Country(3,"province3"));
        countries.add(new Country(4,"province4"));
    }

    public List<Country> showCountry(){
        return countries;
    }

    public Country findByID(int id){
        for (Country country : countries){
            if(country.getId() == id){
                return country;
            }
        }
        return null;
    }

}
