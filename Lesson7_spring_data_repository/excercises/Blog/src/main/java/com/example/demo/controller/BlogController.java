package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.blog.IBlogService;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/blog/")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public List<Category> categoryList(){
        return iCategoryService.findAll();
    }

    @GetMapping("create")
    public ModelAndView createForm() {
        return new ModelAndView("blog/create", "blog", new Blog());
    }

    @PostMapping("create")
    public String create(@ModelAttribute Blog blog) {
        iBlogService.save(blog);
       return "redirect:/category/list";
    }
}
