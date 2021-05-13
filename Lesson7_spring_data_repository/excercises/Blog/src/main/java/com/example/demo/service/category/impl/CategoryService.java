package com.example.demo.service.category.impl;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return iCategoryRepository.findAll(pageable);
    }

    @Override
    public Page<Category> findByNameContaining(String name, Pageable pageable) {
        return iCategoryRepository.findByNameContaining(name,pageable);
    }


}
