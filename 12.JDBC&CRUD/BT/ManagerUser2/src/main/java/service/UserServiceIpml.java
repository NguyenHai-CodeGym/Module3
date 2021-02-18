package service;

import model.Country;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceIpml implements UserService {
    ConnectionService connectionService = new ConnectionService();

    protected final String SELECT_ALL = "select user.id, user.name, user.email, country.countryName as countryName, country.id as CountryId from `user` left join country on `user`.country_id = country.id";
    protected final String INSERT_INTO = "insert into user (name, email, country_id) values (?,?,?)";
    protected final String DELETE = "delete from user where id = ?";
    protected final String UPDATE = "update user set name = ?, email = ?, country = ? where id = ?";

    @Override
    public List<User> showAll() throws ClassNotFoundException, SQLException {
        List<User> list = new ArrayList<>();
        try (PreparedStatement statement = connectionService.getConnection().prepareStatement(SELECT_ALL);
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                int CountryId = resultSet.getInt("CountryId");
                String CountryName = resultSet.getString("CountryName");

                Country country = new Country(CountryId, CountryName);
                User user = new User(id, name, email, country);

                list.add(user);
            }
        }
        return list;
    }

    @Override
    public void addUser(User data) throws ClassNotFoundException, SQLException {
        try (PreparedStatement statement = connectionService.getConnection().prepareStatement(INSERT_INTO);) {
            statement.setString(1,data.getName());
            statement.setString(2,data.getEmail());
            statement.setInt(3,data.getCountry().getId());

            statement.executeUpdate();
        }
    }

    @Override
    public void editUser(int id, User data) throws ClassNotFoundException {
    try(PreparedStatement statement = connectionService.getConnection().prepareStatement(UPDATE);){

    }
    }

    @Override
    public void removeUser(int id) throws ClassNotFoundException, SQLException {
    try(PreparedStatement statement = connectionService.getConnection().prepareStatement(DELETE);) {
        statement.setInt(1,id);
        statement.executeUpdate();
    }
    }

    @Override
    public User findById(int id) {
        return null;
    }
}
