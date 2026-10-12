package com.bank.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bank.project.model.Customer;
import com.bank.project.service.CustomerService;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/api/customers") 
@RestController 
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        try {
            customerService.createCustomer(customer);
            return new ResponseEntity<>("customer is created",HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
           return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @GetMapping
    public  ResponseEntity<?> getAllCustomers() {
        try {
            List<Customer> customerData=customerService.getAllCustomers();
            return new ResponseEntity<>(customerData,HttpStatus.OK);
        } catch (ResponseStatusException e) {
           return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        try {
            Customer customer = customerService.getCustomerByID(id);
            return ResponseEntity.ok(customer);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customer) {
        try {
            Customer updatedCustomer = customerService.updateCustomer(id, customer);
            return ResponseEntity.ok(updatedCustomer);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        try {
            String output=customerService.deleteCustomer(id);
            return new ResponseEntity<>(output,HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
    
    
}
