package controller;

import model.Post;
import service.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DeletePostServlet", urlPatterns = "/deletePost")
public class DeletePostServlet extends HttpServlet {
    PostService postService = new PostService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        postService.delete(id);

        List<Post> postList = null;

        try {
            postList = postService.showAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("list",postList);
        request.setAttribute("mess","Done...!!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-post.jsp");
        dispatcher.forward(request,response);
    }
}
