package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.service.product.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart youCart() {
        return new Cart();
    }

//    @GetMapping("/products")
//    public ModelAndView showProduct() {
//        return new ModelAndView("/index", "products", productService.findAll());
//    }

    @GetMapping("/product-create")
    public ModelAndView createForm() {
        return new ModelAndView("/product/create", "product", new Product());
    }

    @PostMapping("/product-create")
    public ModelAndView create(@ModelAttribute Product product) {
        productService.save(product);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/product-view/{id}")
    public ModelAndView viewProduct(@PathVariable int id) {
        return new ModelAndView("/product/view", "product", productService.findById(id));
    }

    @GetMapping("/cart-view/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute Cart cart) {
        Product product = productService.findById(id);
        cart.addToCart(product);
        return "redirect:/";
    }
    @GetMapping("/cart")
    public  ModelAndView viewCart( Cart cart){
        return new ModelAndView("/product/view-cart","carts",cart.getCart());
    }
}
