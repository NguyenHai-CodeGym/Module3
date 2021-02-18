package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> showAll() throws ClassNotFoundException, SQLException;

    void addUser(User data) throws ClassNotFoundException, SQLException;

    void editUser(int id, User data) throws ClassNotFoundException;

    void removeUser(int id) throws ClassNotFoundException, SQLException;

    User findById(int id);
}
