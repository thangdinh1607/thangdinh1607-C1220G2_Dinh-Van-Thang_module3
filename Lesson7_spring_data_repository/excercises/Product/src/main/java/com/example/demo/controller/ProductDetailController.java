package com.example.demo.controller;

import com.example.demo.model.ProductDetail;
import com.example.demo.service.product_detail.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductDetailController {
    @Autowired
    ProductDetailService productDetailService;

    @GetMapping("/productDetail-list")
    public ModelAndView showProductDetailList(){
        List<ProductDetail> productDetailList = productDetailService.findAll();
        ModelAndView modelAndView = new ModelAndView("product_detail/list");
        modelAndView.addObject("productDetails",productDetailList);
        return modelAndView;
    }
    @GetMapping("/productDetail-create")
    public ModelAndView createProductDetailForm(){
        ModelAndView modelAndView = new ModelAndView("product_detail/create");
        modelAndView.addObject("productDetail",new ProductDetail());
        return modelAndView;
    }
    @PostMapping("/productDetail-create")
    public ModelAndView createProductDetail(@ModelAttribute ProductDetail productDetail){
        ModelAndView modelAndView = new ModelAndView("redirect:/productDetail-list");
        productDetailService.save(productDetail);
        return modelAndView;
    }
    @GetMapping("/productDetail-edit/{id}")
    public ModelAndView editProductDetailForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("product_detail/edit");
        ProductDetail productDetail = productDetailService.findById(id);
        modelAndView.addObject("productDetail",productDetail);
        return modelAndView;
    }
    @GetMapping("/productDetail-delete/{id}")
    public ModelAndView deleteAnswer(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("product_detail/delete");
        ProductDetail productDetail =  productDetailService.findById(id);
        modelAndView.addObject("productDetail",productDetail);
        return modelAndView;
    }
    @PostMapping("/productDetail-delete")
    public String delete(@ModelAttribute ProductDetail productDetail){
        productDetailService.delete(productDetail.getId());
        return "redirect:/productDetail-list";
    }
}
