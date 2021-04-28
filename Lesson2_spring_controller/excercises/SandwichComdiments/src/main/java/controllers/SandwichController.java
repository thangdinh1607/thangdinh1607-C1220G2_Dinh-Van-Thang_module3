package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping()
    public String getCondiment(){
        return "/sandwich";
    }
    @PostMapping("/condiment")
    public  String condiment( @RequestParam(name ="condiment1"  , required = false , defaultValue = "")String condiment1,
//                              @RequestParam(name ="condiment2"  , required = false , defaultValue = "") String condiment2,
//                              @RequestParam(name ="condiment3"  , required = false , defaultValue = "") String condiment3,
//                              @RequestParam(name ="condiment4"  , required = false , defaultValue = "") String condiment4,
                                 Model model){

        model.addAttribute("name",condiment1);
//        model.addAttribute("name2",condiment2);
//        model.addAttribute("name3",condiment3);
//        model.addAttribute("name4",condiment4);
        return "/condiments";
    }
}
