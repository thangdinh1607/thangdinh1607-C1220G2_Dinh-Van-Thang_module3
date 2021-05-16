package com.example.login.controller;

import com.example.login.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
//@SessionAttributes("user")
public class UserController {
//    @ModelAttribute("user")
//    public User setupUserForm(){
//        return new User();
//    }
    @GetMapping("/")
    public ModelAndView login(@CookieValue(name = "infor", defaultValue = "chua login") String infor) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("cookieValue", infor);
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@ModelAttribute User user, HttpServletResponse response) {
        String infor = "";
        String message = "";
        if ("thang".equals(user.getUsername()) && "111".equals(user.getPassword())) {
            infor = user.getUsername();
            message = "login success";
            Cookie cookie = new Cookie("infor", infor);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
        } else {
            message = "login fail";
        }
        return new ModelAndView("login", "message", message);
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("infor", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return new ModelAndView("redirect:/");
    }
}
