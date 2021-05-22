package com.example.cart.repository;

import com.example.cart.model.Category;
import com.example.cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository  extends JpaRepository<Product,Integer> {
   List<Product> findAllByNameContaining(String string);
}
