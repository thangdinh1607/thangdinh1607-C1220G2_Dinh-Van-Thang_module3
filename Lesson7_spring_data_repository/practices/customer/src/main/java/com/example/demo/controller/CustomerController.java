package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;


    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("province")
    public List<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView createCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New Customer created successfully");
        return modelAndView;
    }
//    @GetMapping("/")
//    public ModelAndView showAll(Pageable pageable){
//        Page<Customer> customerList = customerService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("customer/list");
//        modelAndView.addObject("customers",customerList);
//        return modelAndView;
//    }
    @GetMapping("/delete-customer/{id}")
    public ModelAndView deleteAnswer(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("customer/delete");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete-customer")
    public String delete(@ModelAttribute Customer customer){
        customerService.remove(customer.getId());
        return "redirect:/";
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        Customer customer =  customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
    @PostMapping("/edit-customer")
    public String edit(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/")
    public ModelAndView findName( @PageableDefault(value = 2) Pageable pageable,@RequestParam Optional<String> name){
        Page<Customer> customerList;
        String nameSearch="";
        ModelAndView modelAndView = new ModelAndView("customer/list");
        if(name.isPresent()){
            nameSearch=name.get();
            customerList = customerService.findByFirstName(name.get(), pageable);
            modelAndView.addObject("name",nameSearch);
        }else{
            customerList = customerService.findAll(pageable);
            modelAndView.addObject("name",nameSearch);
        }
        modelAndView.addObject("customers",customerList);
        return modelAndView;
    }
}
