package com.example.cart.controller;

import com.example.cart.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping
    public ModelAndView showList(@PageableDefault(value = 4)Pageable pageable){
        return new ModelAndView("index","categories",iCategoryService.findAll(pageable));
    }
    @GetMapping("/login")
    public String showLoginPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "security/login";
        }
        return "redirect:/";
    }

    @GetMapping("/403")
    public  String erroe403(){
        return "security/403";
    }
}
