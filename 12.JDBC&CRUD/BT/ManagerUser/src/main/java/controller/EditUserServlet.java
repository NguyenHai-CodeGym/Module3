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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EditUserServlet",urlPatterns = "/editUser")
public class EditUserServlet extends HttpServlet {
    UserServiceIpml userServiceIpml = new UserServiceIpml();
    CountryServiceIpml countryServiceIpml = new CountryServiceIpml();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email =request.getParameter("email");

        int countryId = Integer.parseInt(request.getParameter("CountryName"));
        Country country = new Country(countryId);

        User user = new User(name,email,country);

        try {
            userServiceIpml.editUser(id,user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            User user1 = userServiceIpml.findById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Country> countryList = new ArrayList<>();
        try {
            countryList = countryServiceIpml.showAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("mess","Done...!!");
        request.setAttribute("countries",countryList);
        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-user.jsp");
        dispatcher.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-user.jsp");
        User user = new User();
        List<Country> country = new ArrayList<>();
        try {
            user = userServiceIpml.findById(id);
            country = countryServiceIpml.showAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("user",user);
        request.setAttribute("countries",country);
        dispatcher.forward(request,response);
    }
}
