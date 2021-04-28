package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("")
    public String showPage(){
        return "/index";
    }

    @PostMapping("/index")
    public String convert(@RequestParam String usd, Model model){
        Double vnd = Double.parseDouble(usd) *23000;
        model.addAttribute("result",vnd);
        return "/index";
    }
}
