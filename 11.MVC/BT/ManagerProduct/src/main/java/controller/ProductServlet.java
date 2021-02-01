package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "create":
                addProduct(request, response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            this.productService.removeProduct(id);
        }
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if (product ==  null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            product.setNameProduct(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            this.productService.upadateProduct(id,product);
            request.setAttribute("products", product);
            request.setAttribute("message", "Done...!");
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = (int)(Math.random() * 10000);
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = new Product(id,name,price,quantity);
        this.productService.addProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message","Done...!");

        try{
            dispatcher.forward(request, response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "create":
                showAdd(request, response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                showDelete(request,response);
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("products",product);
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findProductById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("products", product);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try{
            dispatcher.forward(request, response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response){
        List<Product> products = this.productService.showProduct();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try{
            dispatcher.forward(request, response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
