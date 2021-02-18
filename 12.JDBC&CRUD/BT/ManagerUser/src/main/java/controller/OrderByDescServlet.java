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

@WebServlet(name = "OrderByAscServlet", urlPatterns = "/orderByDesc")
public class OrderByDescServlet extends HttpServlet {
    UserServiceIpml userServiceIpml = new UserServiceIpml();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-user.jsp");
        try {
            List<User> userList = userServiceIpml.orderByNameDesc();
            request.setAttribute("users", userList);
            dispatcher.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dispatcher.forward(request,response);
    }
}
