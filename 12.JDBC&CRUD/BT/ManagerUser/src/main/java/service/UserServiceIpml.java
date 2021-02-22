package service;

import model.Country;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceIpml implements UserService {
    ConService conService = new ConService();

    protected final String SELECT_ALL = "call showAll()";
    protected final String INSERT_INTO = "call sp_createUser(?,?,?)";
    protected final String UPDATE = "call sp_editUser(?,?,?,?)";
    protected final String SELECTBYID = "call FindById(?)";
    protected final String DELETE_USER = "call sp_deleteUser(?)";
    protected final String SELECT_BY_COUNTRY = "SELECT user.*, country.name as countryName, country.id as countryId from user left join country on  user.country_id = country.id where country.name = ?";
    protected final String ORDER_BY_NAME = "select user.*, country.`name` as countryName, country.id as countryId from user left join country on user.country_id = country.id order by user.`name` desc ";
    @Override
    public List<User> showAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        try {
            conService.getConnection();
            CallableStatement statement = conService.getConnection().prepareCall(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                int countryId = resultSet.getInt("countryId");
                String countryName = resultSet.getString("countryName");
                Country country = new Country(countryId, countryName);
                User user = new User(id, name, email, country);
                userList.add(user);

            }
        }catch (Exception e){
            e.getMessage();
        }
        return userList;
    }

    @Override
    public void addUser(User data) throws SQLException {
        try {
            conService.getConnection();
            CallableStatement statement = conService.getConnection().prepareCall(INSERT_INTO);
            statement.setString(1, data.getName());
            statement.setString(2, data.getEmail());
            statement.setInt(3, data.getCountry().getCountryID());

            statement.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public void editUser(int id, User data) throws SQLException {
        try  {
            conService.getConnection();
            CallableStatement statement = conService.getConnection().prepareCall(UPDATE);
            statement.setString(1, data.getName());
            statement.setString(2, data.getEmail());
            statement.setInt(3, data.getCountry().getCountryID());
            statement.setInt(4, id);

            statement.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public void removeUser(int data) throws SQLException {
    try{
        conService.getConnection();
        CallableStatement statement = conService.getConnection().prepareCall(DELETE_USER);
        statement.setInt(1,data);

        statement.executeUpdate();
        }catch (Exception e){
        e.getMessage();
    }
    }

    @Override
    public User findById(int data) throws SQLException {
        User user = new User();
        try{
            conService.getConnection();
            CallableStatement statement = conService.getConnection().prepareCall(SELECTBYID);
            user = new User();
            statement.setInt(1,data);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                int countryId = resultSet.getInt("countryId");
                String countryName = resultSet.getString("countryName");
                Country country = new Country(countryId, countryName);
                user = new User(id, name, email, country);

            }
        }catch (Exception e){
            e.getMessage();
        }
        return user;
    }

    @Override
    public List<User> findByCountry(String data) throws SQLException {
        try(PreparedStatement statement = conService.getConnection().prepareStatement(SELECT_BY_COUNTRY)) {
           List<User> userList = new ArrayList<>();
            statement.setString(1,data);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int countryID = resultSet.getInt("countryId");
                String countryName = resultSet.getString("countryName");
                Country country = new Country(countryID,countryName);
                User user = new User(id,name,email,country);
                userList.add(user);
            }
            return userList;
        }
    }

    @Override
    public List<User> orderByNameDesc() throws SQLException {
        List<User> userList = new ArrayList<>();
        try(PreparedStatement statement = conService.getConnection().prepareStatement(ORDER_BY_NAME)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int countryID = resultSet.getInt("countryId");
                String countryName = resultSet.getString("countryName");
                Country country = new Country(countryID,countryName);
                User user = new User(id,name,email,country);
                userList.add(user);
            }
            return userList;
        }
    }
}
