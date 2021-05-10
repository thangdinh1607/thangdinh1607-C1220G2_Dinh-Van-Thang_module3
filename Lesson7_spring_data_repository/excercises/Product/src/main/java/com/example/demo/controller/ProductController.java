package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.model.ProductDetail;
import com.example.demo.repository.IProductDetailRepository;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.IProductDetailService;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService iProductService;

    @Autowired
    IProductDetailService iProductDetailService;

    @ModelAttribute("productDetail")
    public List<ProductDetail> productDetails() {
        return iProductDetailService.findAll();
    }

    @GetMapping("/product-create")
    public ModelAndView createProductForm() {
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/product-create")
    public String createProduct(@ModelAttribute Product product) {
        iProductService.save(product);
        return "redirect:/product-list";
    }

    @GetMapping("/product-list")
    public ModelAndView showList() {
        List<Product> productList = iProductService.findAll();
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", productList);
        return modelAndView;
    }
    @GetMapping("/product-delete/{id}")
    public ModelAndView answerDelete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("product/delete");
      Product product = iProductService.findById(id);
      modelAndView.addObject("product",product);
        return modelAndView;
    }
    @PostMapping("/product-delete")
    public String delete(@ModelAttribute Product product){
        iProductService.delete(product.getId());
        return "redirect:/product-list";
    }
}
