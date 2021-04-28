package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping()
    public  String showCalculator(){
        return "/calculator";
    }
    @GetMapping("/action")
    public String Calculator(@RequestParam(name="number1",required = false, defaultValue = "0")double number1,
                                 @RequestParam(name="number2",required = false, defaultValue = "0") double number2,
                             @RequestParam(name="action",required = false, defaultValue = "")String action, Model model) {

        double result;
        switch (action) {
            case "Addition":
                result = number1 + number2;
                model.addAttribute("result", result);
                break;
            case "Subtraction":
                result = number1 - number2;
                model.addAttribute("result", result);
                break;
            case "Multiplication":
                result = number1 * number2;
                model.addAttribute("result", result);
                break;
            case "Division":
                if (number2 != 0) {
                    result = number1 / number2;
                    model.addAttribute("result", result);

                } else {
                    String result1 = " mau so bang 0";
                    model.addAttribute("result", result1);
                }
                break;
            default:
                String result1 = " input false";
                model.addAttribute("result", result1);
        }
        return "/calculator";
    }
}
