package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    public static final String REGEX_EMAIL ="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private Pattern pattern;
    private Matcher matcher;

    @GetMapping()
    public String home(){
        return "/ValidateEmail";
    }
    @PostMapping("/validate")
    public String check(@RequestParam String email, Model model){
        Boolean check = Pattern.compile(REGEX_EMAIL).matcher(email).matches();
        if(check){
            model.addAttribute("email","success");
        }else{
            model.addAttribute("email","false");
        }
        return "/ValidateEmail";
    }
}
