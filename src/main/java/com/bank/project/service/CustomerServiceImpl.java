package com.bank.project.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bank.project.model.Customer;
import com.bank.project.respositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByID(Long id) {
        return customerRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " Id is not Found")
        );
    }

    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer customer = customerRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " Id is not Found")
        );

        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setPhoneNumber(updatedCustomer.getPhoneNumber());

        return customerRepository.save(customer);
    }

    @Override
    public String deleteCustomer(Long id) {
        Customer customer=customerRepository.findById(id).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,id+" Id is not Found")
        );
        customerRepository.delete(customer);

        return "Customer named as "+customer.getFirstName()+" having id of "+id +" is deleted sucessfully";
    }

}
