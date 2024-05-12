package com.learn.twodatabases.entity;

import jakarta.persistence.*;

@Table
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
    private String serialNumber;
    private String manufacturedCountry;

    public Product(){}

    public Product(int productId, String name, String serialNumber, String manufacturedCountry) {
        this.productId = productId;
        this.name = name;
        this.serialNumber = serialNumber;
        this.manufacturedCountry = manufacturedCountry;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturedCountry() {
        return manufacturedCountry;
    }

    public void setManufacturedCountry(String manufacturedCountry) {
        this.manufacturedCountry = manufacturedCountry;
    }
}
