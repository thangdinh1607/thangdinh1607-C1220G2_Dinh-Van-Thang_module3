package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("category/")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("list")
    public ModelAndView showList() {
        return new ModelAndView("category/list", "categories", iCategoryService.findAll());
    }

    @GetMapping("create")
    public ModelAndView createForm() {
        return new ModelAndView("category/create", "category", new Category());
    }

    @PostMapping("create")
    public ModelAndView create(@ModelAttribute Category category) {
        iCategoryService.save(category);
        return new ModelAndView("redirect:/category/list");
    }

    @GetMapping("delete/{id}")
    public ModelAndView answerDelete(@PathVariable int id) {
        return new ModelAndView("category/delete", "category", iCategoryService.findById(id));
    }

    @PostMapping("delete")
    public ModelAndView delete(@ModelAttribute Category category) {
        iCategoryService.delete(category.getId());
        return new ModelAndView("redirect:/category/list");
    }

    @GetMapping("view/{id}")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("category/view", "blogs", iCategoryService.findById(id).getBlog());
    }
}

