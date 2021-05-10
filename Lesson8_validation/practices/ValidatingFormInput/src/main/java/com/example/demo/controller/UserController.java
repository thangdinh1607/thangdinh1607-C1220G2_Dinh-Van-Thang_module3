package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping("/user-list")
    public ModelAndView showList() {
        return new ModelAndView("user/list", "users", iUserService.findAll());
    }

    @GetMapping("/user-create")
    public ModelAndView showFormCreat() {
        return new ModelAndView("user/create", "user", new User());
    }

    @PostMapping("/user-create")
    public String create(@Valid @ModelAttribute User user, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            return "user/create";
        } else
            iUserService.save(user);
            return "redirect:/user-list";
    }
}
