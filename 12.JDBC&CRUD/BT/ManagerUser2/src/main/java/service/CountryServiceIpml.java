package service;

import model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryServiceIpml implements CountryService{
    protected final String SELECT_ALL = "select * from country";
    ConnectionService connectionService = new ConnectionService();
    @Override
    public List<Country> showAll() throws ClassNotFoundException, SQLException {
        List<Country> countryList = new ArrayList<>();
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(SELECT_ALL);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("countryName");
                String countryCode = resultSet.getString("countryCode");

                Country country = new Country(id,name,countryCode);
                countryList.add(country);
            }
        }
        return countryList;
    }

    @Override
    public Country findById(int id) {
        return null;
    }
}
