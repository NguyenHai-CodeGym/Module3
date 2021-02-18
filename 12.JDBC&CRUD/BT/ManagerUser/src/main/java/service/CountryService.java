package service;

import model.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryService {
    List<Country> showAll() throws SQLException;

    Country findById(int id) throws SQLException;
}
