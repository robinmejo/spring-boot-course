package com.bank.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor  
@Entity 
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    Long id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    public Customer(Long id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
}
