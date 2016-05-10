package com.example.library.controller;

import com.example.library.domian.Customer;
import com.example.library.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void getCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String customerList(Model model){
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customer";
    }

    //новый пользователь
    @RequestMapping("customer/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customerform";
    }

    //сохранение
    @RequestMapping(value = "customer", method = RequestMethod.POST)
    public String saveCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer";
    }

    //редактирование
    @RequestMapping("customer/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customerform";
    }
}
