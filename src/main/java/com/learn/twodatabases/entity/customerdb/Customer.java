package com.learn.twodatabases.entity.customerdb;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String name;
    private String city;
    private String contactNumber;

    public Customer(int customerId, String name, String city, String contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.city = city;
        this.contactNumber = contactNumber;
    }
}
