package com.example.demo.controller;

import com.example.demo.model.Province;
import com.example.demo.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProvinceController {
    @Autowired
    IProvinceService iProvinceService;

    @GetMapping("/list-province")
    public ModelAndView showList() {
        List<Province> provinceList = iProvinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("province/list");
        modelAndView.addObject("provinces", provinceList);
        return modelAndView;
    }

    @GetMapping("/create-province")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public String create(@ModelAttribute Province province) {
        iProvinceService.save(province);
        return "redirect:/list-province";
    }
    @GetMapping("/delete-province/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("province/delete");
       modelAndView.addObject("province",iProvinceService.findById(id));
       return modelAndView;
    }
    @PostMapping("/delete-province")
    protected String delete(@ModelAttribute Province province){
        iProvinceService.remove(province.getId());
       return "redirect:/list-province";
    }
    @GetMapping("/edit-province/{id}")
    public ModelAndView editFrom(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("province/edit");
        modelAndView.addObject("province",iProvinceService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit-province")
    public String edit(@ModelAttribute Province province){
        iProvinceService.save(province);
        return "redirect:/list-province";
    }

}
