package service;

import model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryServiceIpml implements CountryService{
    ConService conService = new ConService();

    protected final String SELECT_ALL = "SELECT * FROM country";
    protected final String SELECTBYID = "Select * from country where id = ?";


    @Override
    public List<Country> showAll() throws SQLException {
        List<Country> countryList = new ArrayList<>();
        try(PreparedStatement statement = conService.getConnection().prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String code = resultSet.getString("country_code");

                Country country = new Country(id,name,code);
                countryList.add(country);
            }
        }
        return countryList;
    }

    @Override
    public Country findById(int data) throws SQLException {
        Country country = new Country();
        try(PreparedStatement statement = conService.getConnection().prepareStatement(SELECTBYID)) {
            statement.setInt(1,data);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String countryCode = resultSet.getString("country_code");

                country = new Country(id,name,countryCode);
            }
        }
        return country;
    }
}
