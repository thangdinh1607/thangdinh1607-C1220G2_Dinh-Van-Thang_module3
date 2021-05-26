package com.example.case_study.controller;

import com.example.case_study.model.Contract;
import com.example.case_study.model.ContractDetail;
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

@Controller
@RequestMapping("/contractDetails")
public class ContractDetailController {
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
    public ModelAndView showAllContractDetail(@PageableDefault(value = 4)Pageable pageable){
        return new ModelAndView("contract_detail/list","contractDetails",iContractDetailService.findAll(pageable));
    }
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("contracts", iContractService.findAll());
        model.addAttribute("attach_services", iAttachServiceService.findAll());
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract_detail/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute ContractDetail contractDetail , BindingResult bindingResult,Model model) {
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("contracts", iContractService.findAll());
            model.addAttribute("attach_services", iAttachServiceService.findAll());
            return "contract_detail/create";
        }else{
            iContractDetailService.save(contractDetail);
            return "redirect:/contractDetails";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        iContractDetailService.remove(id);
        return "redirect:/contracts";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("contracts", iContractService.findAll());
        model.addAttribute("attach_services", iAttachServiceService.findAll());
        model.addAttribute("contractDetail", iContractDetailService.findById(id));
        return "contract_detail/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute ContractDetail contractDetail,BindingResult bindingResult , Model model) {
        if(bindingResult.hasFieldErrors()) {
            model.addAttribute("contracts", iContractService.findAll());
            model.addAttribute("attach_services", iAttachServiceService.findAll());
            return "contract_detail/edit";
        }else{
            iContractDetailService.save(contractDetail);
            return "redirect:/contractDetails";
        }
    }
    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("/contract_detail/view", "contractDetail", iContractDetailService.findById(id));
    }

}
