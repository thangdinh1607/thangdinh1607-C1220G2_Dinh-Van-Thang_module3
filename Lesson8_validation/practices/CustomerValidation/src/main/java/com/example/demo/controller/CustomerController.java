package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping("/customer-create")
    public ModelAndView showForm(){
        return new ModelAndView("customer/create","customer",new Customer());
    }
    @PostMapping("/customer-create")
    public String create(@Valid @ModelAttribute Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "customer/create";
        }else{
            iCustomerService.save(customer);
            return "redirect:/customer-list";
        }
    }
    @GetMapping("/customer-list")
       public ModelAndView showList(){
        return new ModelAndView("customer/list","customers",iCustomerService.findAll());
    }

}
