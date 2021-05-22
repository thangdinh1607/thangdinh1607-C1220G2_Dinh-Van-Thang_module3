package com.example.cart.service.product;

import com.example.cart.model.Product;

import java.util.List;

public interface IProductService  {
    List<Product> findAll();
    Product findById(int id);
    void deleteById(int id);
    void save(Product product);
    List<Product> findAllByNameContaining(String string);
}
