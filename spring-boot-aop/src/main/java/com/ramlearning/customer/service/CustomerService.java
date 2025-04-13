package com.ramlearning.customer.service;

import com.ramlearning.customer.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CustomerService {
    List<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
        Collections.addAll(customers,
                new Customer(1, "Ram"),
                new Customer(2, "Kiran"));
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
