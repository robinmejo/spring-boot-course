package com.bank.project.service;

import java.util.List;

import com.bank.project.model.Customer;

public interface CustomerService {
    void createCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerByID(Long id);

    Customer updateCustomer(Long id, Customer customer);

    String deleteCustomer(Long id);

}
