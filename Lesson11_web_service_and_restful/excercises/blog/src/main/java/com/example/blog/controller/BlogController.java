package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blogs")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlog(){
        List<Blog> blogs = iBlogService.findAll();
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(blogs,HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(blog,HttpStatus.CREATED);
        }
    }
}
