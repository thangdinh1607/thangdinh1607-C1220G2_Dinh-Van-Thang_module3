package controller;


import model.Product;
import service.ServiceProduct;
import service.ServiceProductImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
//    @GetMapping("/products/create")
//    public String showFormCreate(Model model){
//        model.addAttribute("product",new Product());
//        return "/create";
//    }
//    @PostMapping("/products/create")
//    public  String create(Product product){
//        product.setId((int) (Math.random() * 1000));
//        serviceProduct.save(product);
//        return "redirect:/products";
//    }
//    @GetMapping("product/{id}/delete")
//    public String delete(@PathVariable int id){
//        serviceProduct.delete(id);
//        return "redirect:/products";
//    }
}
