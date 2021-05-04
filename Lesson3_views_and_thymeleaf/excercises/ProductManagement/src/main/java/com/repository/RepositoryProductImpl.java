package com.repository;

import com.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryProductImpl implements RepositoryProduct{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "exciter", "yamaha"));
        products.put(2, new Product(2, "sirius", "yamaha"));
        products.put(3, new Product(3, "jupiter", "yamaha"));
        products.put(4, new Product(4, "ware", "honda"));
        products.put(5, new Product(5, "Air Black", "honda"));
        products.put(6, new Product(6, "SH", "honda"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }
}
