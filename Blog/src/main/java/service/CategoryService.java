package service;

import dao.ConnDAO;
import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategory{
    ConnDAO connection = new ConnDAO();

    protected final String SELECT_ALL = "select * from category";
    @Override
    public List<Category> showAll() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        try(PreparedStatement statement = connection.getConnection().prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nameCategory = resultSet.getString("nameCategory");

                Category category = new Category(id,nameCategory);
                categoryList.add(category);
            }
        }catch (Exception e){
            e.getMessage();
        }
        return categoryList;
    }

    @Override
    public void insert(Category data) throws SQLException {
    }

    @Override
    public void update(Category data, int id) throws SQLException {

    }


    @Override
    public void delete(int id) {

    }

    @Override
    public Category findByID(int id) {
        return null;
    }
}
