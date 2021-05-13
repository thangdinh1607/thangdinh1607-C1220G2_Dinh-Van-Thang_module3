package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("category/")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("list")
    public ModelAndView showList(@PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> name) {
        String nameSearch = "";
        ModelAndView modelAndView = new ModelAndView("category/list");
        if (name.isPresent()) {
            nameSearch = name.get();
            modelAndView.addObject("name", nameSearch);
            modelAndView.addObject("categories", iCategoryService.findByNameContaining(name.get(), pageable));
        } else {
            modelAndView.addObject("name", nameSearch);
            modelAndView.addObject("categories", iCategoryService.findAll(pageable));
        }
        return modelAndView;
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
        ModelAndView modelAndView = new ModelAndView("category/view");
        modelAndView.addObject("blogs", iCategoryService.findById(id).getBlog());
        modelAndView.addObject("categories", iCategoryService.findById(id));
        return modelAndView;
    }
}

