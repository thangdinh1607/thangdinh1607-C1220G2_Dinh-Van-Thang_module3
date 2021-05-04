package controller;


import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;
import service.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.List;
@Controller
public class CustomerController {
    CustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/customer")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("customer/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        customerService.remove(id);
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("customer/{id}/edit")
    public String formEdit(@PathVariable int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/edit";
    }

    @PostMapping("/customer/edit")
    public String edit(Customer customer, Model model) {
        customerService.update(customer.getId(), customer);
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer",  customerService.findById(id));
        return "/view";
    }

    @GetMapping("customer/create")
    public String formCreate(Model model) {
        model.addAttribute("customer",new Customer());
        return "/create";
    }
    @PostMapping("customer/create")
    public String create(Customer customer,Model model) {
        customer.setId((int)Math.random()*10000);
        customerService.save(customer);
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }
}
