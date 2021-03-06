package controller;

import model.Country;
import model.User;
import service.CountryServiceIpml;
import service.UserServiceIpml;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddProductServlet", urlPatterns = "/addUser")
public class AddProductServlet extends HttpServlet {
    UserServiceIpml userServiceIpml = new UserServiceIpml();
    CountryServiceIpml countryServiceIpml = new CountryServiceIpml();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        int countryId = Integer.parseInt(request.getParameter("CountryName"));
        Country country = new Country(countryId);
        User user = new User(name,email,country);
        try {
           userServiceIpml.addUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-user.jsp");
        request.setAttribute("mess","Done...!");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-user.jsp");
        List<Country> countryList = null;
        try {
            countryList = countryServiceIpml.showAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("countrys",countryList);
        dispatcher.forward(request,response);
    }
}
