package com.example.case_study.controller;


import com.example.case_study.model.Customer;
import com.example.case_study.model.CustomerType;
import com.example.case_study.service.customer.Impl.ICustomerService;
import com.example.case_study.service.customer_type.Impl.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
  private ICustomerTypeService iCustomerTypeService;

    @GetMapping
    public ModelAndView showAllCustomer(@PageableDefault(value = 4 )Pageable pageable){
        return new ModelAndView("customer/list","customers",iCustomerService.findAll(pageable));
    }
//    @GetMapping("list/{name}")
//    public ModelAndView findAllCustomer( @PathVariable String name ){
//        return new ModelAndView("customer/list","customers",iCustomerService.findAllByNameContaining(name));
//    }
    @GetMapping("/create")
    public String createForm(Model model){
        List<CustomerType> customerTypeList= iCustomerTypeService.findAll();
        model.addAttribute("customerTypes",customerTypeList);
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer){
        iCustomerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
    iCustomerService.remove(id);
    return "redirect:/customers";
    }
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id ,Model model){
        model.addAttribute("customerTypes",iCustomerTypeService.findAll());
        model.addAttribute("customer",iCustomerService.findById(id));
        return "customer/edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Customer customer){
       iCustomerService.save(customer);
       return "redirect:/customers";
    }
    @GetMapping("/view/{id}")
    public ModelAndView view (@PathVariable int id){
        return new  ModelAndView("/customer/view","customer",iCustomerService.findById(id));
    }
}

