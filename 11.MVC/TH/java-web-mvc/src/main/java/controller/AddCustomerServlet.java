package controller;

import model.Country;
import model.Customer;
import service.BaseService;
import service.CountryService;
import service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/addCustomer")
public class AddCustomerServlet extends HttpServlet {
    private BaseService customerService = new CustomerService();
    private CountryService countryService = new CountryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (int) (Math.random() * 10000);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idCountry=Integer.parseInt(request.getParameter("country"));
        Country country=countryService.findByID(idCountry);

        Customer customer = new Customer(id, name, email, address,country);
        customerService.save(customer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("add-customer.jsp");
        Customer cus = new Customer();
        request.setAttribute("customer", cus);
        request.setAttribute("mess","Done...!");
        dispatcher.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-customer.jsp");
        Customer customer = new Customer();
        List<Country> countries = countryService.showCountry();
        request.setAttribute("countries",countries);
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }
}
