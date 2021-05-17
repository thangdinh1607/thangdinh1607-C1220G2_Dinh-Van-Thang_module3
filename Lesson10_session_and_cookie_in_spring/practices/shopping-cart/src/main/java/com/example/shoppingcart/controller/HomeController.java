package com.example.shoppingcart.controller;

import com.example.shoppingcart.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView showListProduct(){
        return  new ModelAndView("/index","products",productService.findAll());
    }
}
