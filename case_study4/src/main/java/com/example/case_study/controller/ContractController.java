package com.example.case_study.controller;


import com.example.case_study.model.Contract;
import com.example.case_study.service.attach_service.Impl.IAttachServiceService;
import com.example.case_study.service.contrac_detail.Impl.IContractDetailService;
import com.example.case_study.service.contract.Impl.IContractService;
import com.example.case_study.service.customer.Impl.ICustomerService;
import com.example.case_study.service.employee.Impl.IEmployeeService;
import com.example.case_study.service.service.Impl.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private IContractService iContractService;
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IAttachServiceService iAttachServiceService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IServiceService iServiceService;


    @GetMapping
    public String showAllContract(@PageableDefault(value = 4) Pageable pageable,Model model) {
        model.addAttribute("contracts",iContractService.findAll(pageable));
        return "contract/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("customers", iCustomerService.findAll());
        model.addAttribute("employees", iEmployeeService.findAll());
        model.addAttribute("services", iServiceService.findAll());
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Contract contract,BindingResult bindingResult,Model model) {
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customers", iCustomerService.findAll());
            model.addAttribute("employees", iEmployeeService.findAll());
            model.addAttribute("services", iServiceService.findAll());
            return "contract/create";
        }else {
            iContractService.save(contract);
            return "redirect:/contracts";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        iContractService.remove(id);
        return "redirect:/contracts";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("customers", iCustomerService.findAll());
        model.addAttribute("employees", iEmployeeService.findAll());
        model.addAttribute("services", iServiceService.findAll());
        model.addAttribute("contract", iContractService.findById(id));
        return "contract/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute Contract contract, BindingResult bindingResult , Model model) {
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customers", iCustomerService.findAll());
            model.addAttribute("employees", iEmployeeService.findAll());
            model.addAttribute("services", iServiceService.findAll());
            return "contract/edit";
        }else  {
            iContractService.save(contract);
            return "redirect:/contracts";
        }

    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("/contract/view", "contract", iContractService.findById(id));
    }

}
