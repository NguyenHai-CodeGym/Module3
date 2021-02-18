package controller;

import model.User;
import service.UserServiceIpml;

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

@WebServlet(name = "SearchUserServlet", urlPatterns = "/searchUser")
public class SearchUserServlet extends HttpServlet {
    UserServiceIpml userServiceIpml = new UserServiceIpml();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CountryName = request.getParameter("search");
        List<User> userList = new ArrayList<>();
        try {
           userList = userServiceIpml.findByCountry(CountryName);
            request.setAttribute("users",userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("search-user.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("search-user.jsp");
        dispatcher.forward(request,response);
    }
}
