package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Category;
import com.example.cart.model.Product;
import com.example.cart.service.category.ICategoryService;
import com.example.cart.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.xml.ws.Binding;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/cart/{id}")
    public String addToCart(@ModelAttribute Cart cart,@PathVariable int id,Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product",product);
        if(product == null){
            return "/error-page";
        }else {
            cart.addToCart(product);
            model.addAttribute("msg","Add " + product.getName() + " to cart successfully : " + cart.countProductQuantity(product));
        }
        return "/product/view";
    }

    @GetMapping("/cart")
    public String viewCart(@ModelAttribute Cart cart,Model model) {
       model.addAttribute("carts",cart.getCart());
        model.addAttribute("totalPayment",cart.countTotalPayment());
        model.addAttribute("countItemQuantity",cart.countItemQuantity());
        return "cart/view";
    }


    @GetMapping("/list/{id}")
    public ModelAndView showProductByCategory(@PathVariable int id) {
        return new ModelAndView("product/list", "products", iCategoryService.findById(id).getProducts());
    }

    @GetMapping
    public ModelAndView showAllProduct() {
        return new ModelAndView("product/list", "products", iProductService.findAll());
    }

    @GetMapping("/create")
    public String createFromProduct(Model model) {
        model.addAttribute("categories", iCategoryService.findAll());
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute Product product , BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "product/create";
        }else{
            iProductService.save(product);
            return "redirect:/products";
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView answerDelete(@PathVariable int id) {
        return new ModelAndView("product/delete", "product", iProductService.findById(id));
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product) {
        iProductService.deleteById(product.getId());
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("categories", iCategoryService.findAll());
        model.addAttribute("product", iProductService.findById(id));
        return "product/edit";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showProduct(@PathVariable int id) {
        return new ModelAndView("product/view", "product", iProductService.findById(id));
    }
    @GetMapping("/findByName/{name}")
    public ModelAndView findByName(@PathVariable String name){
        return new ModelAndView("findByName","products",iProductService.findAllByNameContaining(name));
    }
}