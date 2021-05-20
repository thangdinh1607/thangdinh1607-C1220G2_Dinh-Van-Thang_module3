package com.example.customer_management.controller;

import com.example.customer_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @GetMapping("/")
    public String getInternationalPage(Model model){
        model.addAttribute("customers",iCustomerService.findAll());
        return "index";
    }
}
