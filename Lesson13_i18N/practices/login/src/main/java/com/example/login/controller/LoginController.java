package com.example.login.controller;

import com.example.login.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String getInternationalPage(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
}
