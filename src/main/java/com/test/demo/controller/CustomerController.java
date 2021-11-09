package com.test.demo.controller;

import com.test.demo.entity.Customer;
import com.test.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // this mapping handles all HTTP methods but may not be optimal for everything like it is
    @RequestMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCostumers());

        // the jsp view
        return "list-costumers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();

        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")  // same values as in the jsp form
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveOrUpdate(customer);
        return "redirect:/customer/list";
    }

    // all params comes from the jsp
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {

        Customer customerRetrieved = customerService.getClientById(customerId);

        model.addAttribute("customer", customerRetrieved);
        return "customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {
        Customer customerRetrieved = customerService.getClientById(customerId);

        customerService.deleteCustomer(customerRetrieved);
        return "redirect:/customer/list";
    }


}
