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
import java.util.List;

@WebServlet(name = "EditCustomerServlet", urlPatterns = "/editCustomer")
public class EditCustomerServlet extends HttpServlet {
    private BaseService customerService = new CustomerService();
    private CountryService countryService = new CountryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idCountry=Integer.parseInt(request.getParameter("country"));
        Country country=countryService.findByID(idCountry);
        Customer customer = new Customer(id, name, email, address, country);
        customerService.update(id, customer);
        List<Country> countries = countryService.showCountry();
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-customer.jsp");
        request.setAttribute("customer", customer);
        request.setAttribute("countries", countries);
        request.setAttribute("mess", "Done...!");
        request.setAttribute("idCountry",idCountry);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Country> countries = countryService.showCountry();

        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-customer.jsp");
        request.setAttribute("customer", customer);
        request.setAttribute("countries", countries);
        dispatcher.forward(request, response);
    }
}
