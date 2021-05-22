package com.example.cart.service.category;


import com.example.cart.model.Category;
import com.example.cart.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);
    Category findById(int id);
    List<Category> findAll();
}
