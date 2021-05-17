package com.example.demo.controller;


import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.ProductDetail;
import com.example.demo.service.category.ICategoryService;
import com.example.demo.service.product_detail.IProductDetailService;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return iCategoryService.findAll();
    }

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
    public ModelAndView showList(@PageableDefault (value = 2)Pageable pageable) {
        return new  ModelAndView("product/list","products", iProductService.findAll(pageable));
    }

    @GetMapping("/product-delete/{id}")
    public ModelAndView answerDelete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("product/delete");
        Product product = iProductService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/product-delete")
    public String delete(@ModelAttribute Product product) {
        iProductService.delete(product.getId());
        return "redirect:/product-list";
    }

    @GetMapping("/product-view/{id}")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("product_detail/view", "product", iProductService.findById(id));
    }

    @GetMapping("/product-edit/{id}")
    public ModelAndView editForm(@PathVariable int id){
        return new ModelAndView("product/edit","product",iProductService.findById(id));
    }

    @PostMapping ("/product-edit")
    public ModelAndView edit (@ModelAttribute Product product){
       iProductService.save(product);
       return new ModelAndView("redirect:/product-list");
    }
}
