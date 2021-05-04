package com.service;

import com.model.Product;
import com.repository.RepositoryProduct;
import com.repository.RepositoryProductImpl;

import java.util.List;

public class ServiceProductImpl implements ServiceProduct {
    RepositoryProduct repositoryProduct = new RepositoryProductImpl();

    @Override
    public List<Product> findAll() {
        return repositoryProduct.findAll();
    }

    @Override
    public void save(Product product) {
        repositoryProduct.save(product);
    }

    @Override
    public void update(int id, Product product) {
    repositoryProduct.update(id,product);
    }

    @Override
    public void delete(int id) {
repositoryProduct.delete(id);
    }

    @Override
    public Product findById(int id) {
        return repositoryProduct.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }
}
