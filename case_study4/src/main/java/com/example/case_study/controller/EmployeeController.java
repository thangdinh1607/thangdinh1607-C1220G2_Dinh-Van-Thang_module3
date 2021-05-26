package com.example.case_study.controller;

import com.example.case_study.model.Employee;
import com.example.case_study.service.division.Impl.IDivisionService;
import com.example.case_study.service.education_degree.impl.IEducationDegreeService;
import com.example.case_study.service.employee.Impl.IEmployeeService;
import com.example.case_study.service.position.Impl.IPositionService;
import com.example.case_study.service.user.Impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IUserService iuserService;


    @GetMapping
    public ModelAndView showAllEmployee(@PageableDefault(value = 4) Pageable pageable) {
        return new ModelAndView("/employee/list", "employees", iEmployeeService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView creatForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("divisions", iDivisionService.findAll());
        modelAndView.addObject("positions", iPositionService.findAll());
        modelAndView.addObject("educationDegree", iEducationDegreeService.findAll());
        modelAndView.addObject("users", iuserService.findAll());
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/employee/create");
            modelAndView.addObject("divisions", iDivisionService.findAll());
            modelAndView.addObject("positions", iPositionService.findAll());
            modelAndView.addObject("educationDegree", iEducationDegreeService.findAll());
            modelAndView.addObject("users", iuserService.findAll());
            return modelAndView;
        } else {
            iEmployeeService.save(employee);
            return new ModelAndView("redirect:/employees");
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("divisions", iDivisionService.findAll());
        modelAndView.addObject("positions", iPositionService.findAll());
        modelAndView.addObject("educationDegrees", iEducationDegreeService.findAll());
        modelAndView.addObject("users", iuserService.findAll());
        modelAndView.addObject("employee", iEmployeeService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Valid @ModelAttribute Employee employee,BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("divisions", iDivisionService.findAll());
            modelAndView.addObject("positions", iPositionService.findAll());
            modelAndView.addObject("educationDegree", iEducationDegreeService.findAll());
            modelAndView.addObject("users", iuserService.findAll());
            return modelAndView;
        }else{
            iEmployeeService.save(employee);
            return new ModelAndView("redirect:/employees");
        }
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("/employee/view", "employee", iEmployeeService.findById(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        iEmployeeService.remove(id);
        return new ModelAndView("redirect:/employees");
    }

}
