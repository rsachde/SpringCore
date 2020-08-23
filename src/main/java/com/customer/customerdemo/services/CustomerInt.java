package com.customer.customerdemo.services;

import com.customer.customerdemo.domain.Customer;

import java.util.List;

public interface CustomerInt {

     List<Customer> getAllCustomer();
     Customer getCustomerById(int id);
     void addNewCustomer(Customer customer);
     void deleteCustomer(int id);
}
