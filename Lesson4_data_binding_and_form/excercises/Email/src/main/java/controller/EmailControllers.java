package controller;


import model.Languages;
import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailControllers {
    @GetMapping
    public String formRequestEmail(ModelMap modelMap) {

        modelMap.addAttribute("setting",new Setting());
        List<Languages> languagesList = new ArrayList<>();

        languagesList.add(new Languages("English"));
        languagesList.add(new Languages("Vietnamese"));
        languagesList.add(new Languages("Japanese"));
        languagesList.add(new Languages("Laos"));
        modelMap.addAttribute("Languages",languagesList);

        int arr[] = {5,10,15,20};
        modelMap.addAttribute("sizePage",arr);
        return "/formEmail";
    }
    @PostMapping("/info")
    public String info(@ModelAttribute("setting") Setting setting , ModelMap modelMap  ){
        modelMap.addAttribute("setting",setting);
        return "/info";
    }
}
