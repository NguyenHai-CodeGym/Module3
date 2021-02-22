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
import java.util.List;

@WebServlet(name = "EditPostServlet", urlPatterns = "/editPost")
public class EditPostServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    PostService postService = new PostService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("postid"));
       String title = request.getParameter("title");
       String fullContent = request.getParameter("fullContent");
       String shortContent = request.getParameter("shortContent");
       String image = request.getParameter("image");

       int categoryId = Integer.parseInt(request.getParameter("category"));

       Category category = new Category(categoryId);
       Post post = new Post(title,fullContent,shortContent,image,category);
        List<Category> categoryList = null;

        try {
            postService.update(post,id);
            categoryList = categoryService.showAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-post.jsp");
        request.setAttribute("post",post);
        request.setAttribute("category",categoryList);
        request.setAttribute("mess","Done...!!!");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-post.jsp");
        Post post = null;
        List<Category> categoryList = null;
        try {
            post = postService.findByID(id);
           categoryList= categoryService.showAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("post",post);
        request.setAttribute("category",categoryList);
        dispatcher.forward(request,response);
    }
}
