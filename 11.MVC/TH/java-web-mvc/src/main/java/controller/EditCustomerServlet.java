package controller;

import model.Customer;
import service.BaseService;
import service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditCustomerServlet", urlPatterns = "/editCustomer")
public class EditCustomerServlet extends HttpServlet {
    private BaseService customerService = new CustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id,name,email,address);
        customerService.update(id,customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-customer.jsp");
        request.setAttribute("customer",customer);
        request.setAttribute("mess","Done...!");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));

        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-customer.jsp");
        request.setAttribute("customer",customer);

        dispatcher.forward(request,response);
    }
}
