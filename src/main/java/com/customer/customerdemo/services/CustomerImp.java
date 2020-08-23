package com.customer.customerdemo.services;

import com.customer.customerdemo.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerImp implements CustomerInt {

    HashMap<Integer, Customer> customers= new LinkedHashMap<>();

    public CustomerImp() {
        loadCustomers();
    }

    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Micheal");
        customer1.setLastName("Weston");
        customer1.setCity("Miami");
        customer1.setState("Florida");
        customer1.setZipCode("33101");
        customer1.setEmail("micheal@burnnotice.com");
        customers.put(1, customer1);


        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Fiona");
        customer2.setLastName("Glenanne");
        customer2.setCity("Miami");
        customer2.setState("Florida");
        customer2.setZipCode("33101");
        customer2.setEmail("fiona@burnnotice.com");
        customers.put(2, customer2);


        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Sam");
        customer3.setLastName("Axe");
        customer3.setCity("Miami");
        customer3.setState("Florida");
        customer3.setZipCode("33101");
        customer3.setEmail("sam@burnnotice.com");
        customers.put(3, customer3);

    }

    @Override
    public List<Customer> getAllCustomer() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(int id) {
        if(customers.containsKey(id))
            return customers.get(id);
        else
            return null;
    }

    @Override
    public void addNewCustomer(Customer customer) {
        if(customer != null)
        {
            int maxs= getMaxKey();
            System.out.println("max " + maxs);
            customer.setId(maxs);
            customers.put(maxs, customer);
        }
        else
        {
            System.out.println("Please Provide Some Value");
        }
    }

    public int getMaxKey()
    {
        int max=Collections.max(customers.keySet());
        max++;
        return max;
    }

    public void deleteCustomer(int id)
    {
        if(customers.containsKey(id))
        {
            customers.remove(id);
        }
        else
        {
            System.out.println("Suspect not found");
        }
    }
}
