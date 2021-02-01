package service;
import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> showProduct();

    void addProduct(Product product);
    void upadateProduct(int id,Product product);
    void removeProduct(int id);
    Product findProductById(int id);

}
