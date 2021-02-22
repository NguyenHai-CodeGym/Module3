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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListServlet", urlPatterns = "/listPost")
public class ListServlet extends HttpServlet {
    PostService postService = new PostService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-post.jsp");
        List<Post> postList = null;
        try {
            postList = postService.showAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(postList);

        request.setAttribute("list",postList);
        dispatcher.forward(request,response);
    }
}
