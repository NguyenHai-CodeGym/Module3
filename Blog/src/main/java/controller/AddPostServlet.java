package controller;

import model.Category;
import model.Post;
import service.CategoryService;
import service.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddPostServlet", urlPatterns = "/addPost")
public class AddPostServlet extends HttpServlet {
    PostService postService = new PostService();
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String title = request.getParameter("title");
    String fullContent = request.getParameter("fullContent");
    String shortContent = request.getParameter("shortContent");
    String image = request.getParameter("image");

    int CategoryID = Integer.parseInt(request.getParameter("category"));

    Category categoryID = new Category(CategoryID);

    Post post = new Post(title,fullContent,shortContent,image,categoryID);
        try {
            postService.insert(post);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-post.jsp");
        request.setAttribute("mess","Done.....!");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-post.jsp");
        List<Category> categoryList =  new ArrayList<>();
        try {
            categoryList = categoryService.showAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("cateList",categoryList);
        dispatcher.forward(request,response);
    }
}
