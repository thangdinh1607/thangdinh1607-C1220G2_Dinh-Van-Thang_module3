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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public String create(@ModelAttribute Service service) {
        iServiceService.save(service);
        return "redirect:/services";
    }
}
