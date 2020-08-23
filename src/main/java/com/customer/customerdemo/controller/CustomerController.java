package com.customer.customerdemo.controller;

import com.customer.customerdemo.domain.Customer;
import com.customer.customerdemo.services.CustomerInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    CustomerInt customerInt;

    @Autowired
    public void setCustomerInt(CustomerInt customerInt) {
        this.customerInt = customerInt;
    }

    @RequestMapping("/customers")
    public String getAllCustomer(Model model) {

        model.addAttribute("customers", customerInt.getAllCustomer());
        return "custom";
    }

    @RequestMapping("/customers/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "newCustomer";
    }

    @RequestMapping("/customers/{id}")
    public String getCustomerById(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerInt.getCustomerById(id));
        return "customerById";
    }


    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public String saveAndUpdateProduct(Customer customer, Model model) {
        customerInt.addNewCustomer(customer);
        return "redirect:/customers";
    }

    @RequestMapping(value = "/customers/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id, Model model) {
        customerInt.deleteCustomer(id);
        return "redirect:/customers/";
    }

    @RequestMapping(value = "/customers/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerInt.getCustomerById(id));
        return "newCustomer";
    }

    @RequestMapping(value = "/customers/show/{id}")
    public String customerById(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerInt.getCustomerById(id));
        return "customerById";
    }
}
