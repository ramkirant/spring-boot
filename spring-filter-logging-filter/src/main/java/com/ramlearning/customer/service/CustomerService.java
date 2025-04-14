package com.ramlearning.customer.service;

import com.ramlearning.customer.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
        Collections.addAll(customers,
                new Customer(1, "Ram"),
                new Customer(2, "Kiran"));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }
}
