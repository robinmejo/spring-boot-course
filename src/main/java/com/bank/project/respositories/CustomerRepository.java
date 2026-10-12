package com.bank.project.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.project.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
