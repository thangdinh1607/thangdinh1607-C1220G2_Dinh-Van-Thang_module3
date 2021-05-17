package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;

import com.example.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;


    @GetMapping
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> categories = iCategoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        iCategoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Category> edit(@PathVariable int id,@RequestBody Category category){
        if(category==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            category.setId(id);
            iCategoryService.save(category);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Blog>> getBlogByCategory(@PathVariable int  id){
        Category category = iCategoryService.findById(id);
        return new ResponseEntity<>(category.getBlog(), HttpStatus.OK);
    }
}
