package com.example.case_study.controller;

import com.example.case_study.model.Service;
import com.example.case_study.service.rent_type.Impl.IRentypeService;
import com.example.case_study.service.service.Impl.IServiceService;
import com.example.case_study.service.service_type.Impl.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private IServiceService iServiceService;

    @Autowired
    private IServiceTypeService iServiceServiceType;

    @Autowired
    private IRentypeService iRentypeService;

    @GetMapping
    public ModelAndView showAllService(@PageableDefault(value = 3) Pageable pageable) {
        return new ModelAndView("service/list", "services", iServiceService.findAll(pageable));
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("service", new Service());
        model.addAttribute("rentTypes", iRentypeService.findAll());
        model.addAttribute("serviceTypes", iServiceServiceType.findAll());
        return "service/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Service service, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("rentTypes", iRentypeService.findAll());
            model.addAttribute("serviceTypes", iServiceServiceType.findAll());
            return "service/create";
        } else {
            iServiceService.save(service);
            return "redirect:/services";
        }

    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {

        return new ModelAndView("/service/view", "service", iServiceService.findById(id));
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        iServiceService.remove(id);
        return "redirect:/services";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        ModelAndView modelAndView = new ModelAndView("service/edit");
        model.addAttribute("service", iServiceService.findById(id));
        model.addAttribute("rentTypes", iRentypeService.findAll());
        model.addAttribute("serviceTypes", iServiceServiceType.findAll());
        return "service/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Service service, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("rentTypes", iRentypeService.findAll());
            model.addAttribute("serviceTypes", iServiceServiceType.findAll());
            return "service/edit";
        } else {
            iServiceService.save(service);
            return "redirect:/services";
        }
    }
}
