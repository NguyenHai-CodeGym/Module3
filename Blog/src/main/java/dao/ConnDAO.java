package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Nguyenhai@0603";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
