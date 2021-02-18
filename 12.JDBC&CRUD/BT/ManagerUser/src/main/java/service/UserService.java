package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> showAll() throws SQLException;

    void addUser(User data) throws SQLException;

    void editUser(int id, User data) throws SQLException;

    void removeUser(int data) throws SQLException;

    User findById(int data) throws SQLException;

    List<User> findByCountry(String data) throws SQLException;

    List<User> orderByNameDesc() throws SQLException;
}
