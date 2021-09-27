package com.test.demo.controller;

import com.test.demo.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @RequestMapping("/list")
    public String listCustomers(Model model){
        model.addAttribute("customers", customerDao.getAllCostumers());

        // the jsp view
        return "list-costumers";
    }
}
