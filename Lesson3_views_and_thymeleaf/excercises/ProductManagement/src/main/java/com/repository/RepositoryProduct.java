package com.repository;

import com.model.Product;

import java.util.List;

public interface RepositoryProduct {
    List<Product> findAll();
    void save(Product product);
    void update(int id , Product product);
    void delete(int id);
    Product findById(int id);
    Product findByName(String name);
}
