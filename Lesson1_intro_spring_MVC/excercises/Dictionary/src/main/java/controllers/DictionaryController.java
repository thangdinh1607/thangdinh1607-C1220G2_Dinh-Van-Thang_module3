package controllers;

import model.service.DictionaryService;
import model.service.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryServiceImpl dictionaryService;

    @GetMapping()
    public String showForm() {
        return "/index";
    }

    @PostMapping("/dictionary")
    public String search(@RequestParam String search, Model model) {
//        Map<String, String> dictionary = new HashMap<>();
//        dictionary.put("hello", "Xin chào");
//        dictionary.put("how", "Thế nào");
//        dictionary.put("book", "Quyển vở");
//        dictionary.put("computer", "Máy tính");
//
//        String result = dictionary.get(search);
//        if(result!=null){
//            model.addAttribute("result",result);
//        }else{
//            model.addAttribute("result","not found");
//        }

        String result = dictionaryService.search(search);

        if (result != null) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "not found");
        }
        return "/index";
    }
}
