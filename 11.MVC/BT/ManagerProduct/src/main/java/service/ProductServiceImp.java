package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements ProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Motocar", 2000, 2200));
        productMap.put(2, new Product(2, "Phone", 500, 1600));
        productMap.put(3, new Product(3, "Helicopter", 2000, 800));
    }

    @Override
    public List<Product> showProduct() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void upadateProduct(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void removeProduct(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findProductById(int id) {
        return productMap.get(id);
    }

}
