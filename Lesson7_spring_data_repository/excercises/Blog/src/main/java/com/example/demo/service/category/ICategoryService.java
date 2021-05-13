package com.example.demo.service.category;

import com.example.demo.model.Category;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category> {
    Page<Category> findAll(Pageable pageable);
    Page<Category> findByNameContaining(String name,Pageable pageable);
}
