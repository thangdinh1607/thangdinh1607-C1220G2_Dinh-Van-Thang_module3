package com.example.cart.service.product;

import com.example.cart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService  {
    Page<Product>findAll(Pageable pageable);
    Product findById(int id);
    void deleteById(int id);
    void save(Product product);
    List<Product> findAllByNameContaining(String string);

}
