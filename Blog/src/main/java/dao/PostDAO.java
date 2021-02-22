package dao;

import model.Category;
import model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends ConnDAO implements IBaseDAO<Post> {

    protected final String SELECT_ALL = "select post.id as id, title, fullContent, shortContent, publishDate, image, idCategory, nameCategory from post inner join category on post.idCategory = category.id";

    @Override
    public List<Post> showAll() throws SQLException {
        List<Post> poList = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String fullContent = resultSet.getString("fullContent");
                String shortContent = resultSet.getString("shortContent");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dateTime = resultSet.getString("publishDate");
                LocalDateTime publishDate = LocalDateTime.parse(dateTime, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String categoryName = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, categoryName);
                Post post = new Post(id, title, fullContent, shortContent, publishDate, image, category);

                poList.add(post);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return poList;
    }

    @Override
    public void insert(Post data) throws SQLException {

    }

    @Override
    public void update(Post data) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Post fidnByID(int id) {
        return null;
    }
}
