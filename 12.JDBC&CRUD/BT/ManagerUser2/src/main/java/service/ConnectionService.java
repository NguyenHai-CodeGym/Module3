package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/manageruser2";
    private final String jdbcUser = "root";
    private final String jdbcPassWord = "Nguyenhai@0603";

    public Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPassWord);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


}
