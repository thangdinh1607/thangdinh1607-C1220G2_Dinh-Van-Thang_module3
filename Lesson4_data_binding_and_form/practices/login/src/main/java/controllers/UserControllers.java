package controllers;


import Dao.UserDao;
import model.bean.Login;
import model.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserControllers {
    @GetMapping
    public String showLogin(ModelMap modelMap) {
        modelMap.addAttribute("user",new User());
        return "/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login, ModelMap modelMap){
    User user = UserDao.checkLogin(login);
    if(user ==null){
        modelMap.addAttribute("err","err");
    }else{
        modelMap.addAttribute("user",user);
    }
    return "/info";
    }
}
