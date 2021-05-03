package controllers;


import model.bean.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @GetMapping
    public String showForm(ModelMap modelMap){
        modelMap.addAttribute("employee", new Employee());
        return "/employee/create";
    }
    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute("employee")Employee employee ,ModelMap modelMap){
        modelMap.addAttribute("name",employee.getName());
        modelMap.addAttribute("id",employee.getId());
        modelMap.addAttribute("contractNumber",employee.getContractNumber());

        return "/employee/info";
    }
}
