package com.learn.twodatabases.entity;

import jakarta.persistence.*;

@Table(name = "customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private String city;
    private String contactNumber;

    public Customer(){
        // Default constructor is needed to JPA
    }

    public Customer(int customerId, String name, String city, String contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.city = city;
        this.contactNumber = contactNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
