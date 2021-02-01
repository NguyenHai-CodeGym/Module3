package model;

public class Product {
    private int id;
    private String nameProduct;
    private double price;
    private int quantity;

    public Product(int id, String nameProduct, double price, int quantity) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
    }
    public Product(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
