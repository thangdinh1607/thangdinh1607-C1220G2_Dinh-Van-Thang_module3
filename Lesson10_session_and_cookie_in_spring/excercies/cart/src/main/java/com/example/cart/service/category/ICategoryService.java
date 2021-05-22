package com.example.cart.service.category;


import com.example.cart.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
}
