package com.example.cart.controller;

import com.example.cart.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping
    public ModelAndView showList(){
        return new ModelAndView("index","categories",iCategoryService.findAll());
    }
}
