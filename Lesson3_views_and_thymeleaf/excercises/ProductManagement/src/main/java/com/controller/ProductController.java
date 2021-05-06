package com.controller;


import com.model.Product;
import com.service.ServiceProduct;
import com.service.ServiceProductImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    ServiceProduct serviceProduct = new ServiceProductImpl();
    @GetMapping("/products")
    public String showProduct(Model model){
        List<Product> productList =  serviceProduct.findAll();
        model.addAttribute("products",productList);
        return "/index";
    }
    @GetMapping("/products/create")
    public String showFormCreate(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/products/create")
    public  String create(@ModelAttribute Product product){
        product.setId((int) (Math.random() * 1000));
        serviceProduct.save(product);
        return "redirect:/products";
    }
    @GetMapping("products/{id}/delete")
    public String delete(@PathVariable int id){
        serviceProduct.delete(id);
        return "redirect:/products";
    }
    @GetMapping("products/{id}/edit")
    public  String formEdit(@PathVariable int id,Model model){
        model.addAttribute("product",serviceProduct.findById(id)) ;
        return "/update";
    }
    @PostMapping("products/edit")
    public String edit(@ModelAttribute Product product){
        serviceProduct.update(product.getId(),product);
        return "redirect:/products";
    }
    @GetMapping("products/{id}/view")
    public  String view(@PathVariable int id,Model model){
        model.addAttribute("product",serviceProduct.findById(id)) ;
        return "/view";
    }
}
