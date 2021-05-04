package service;

import model.Product;

import java.util.List;

public interface ServiceProduct {
    List<Product> findAll();
    void save(Product product);
    void update(int id , Product product);
    void delete(int id);
    Product findById(int id);
    Product findByName(String name);
}
