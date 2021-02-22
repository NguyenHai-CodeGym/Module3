package dao;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<T> {
    List<T> showAll() throws SQLException;

    void insert(T data) throws SQLException;

    void update(T data);

    void delete(int id);

    T fidnByID(int id);
}
