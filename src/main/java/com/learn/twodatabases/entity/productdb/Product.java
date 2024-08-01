package com.learn.twodatabases.entity.productdb;

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
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String name;
    private String serialNumber;
    private String manufacturedCountry;

    public Product(int productId, String name, String serialNumber, String manufacturedCountry) {
        this.productId = productId;
        this.name = name;
        this.serialNumber = serialNumber;
        this.manufacturedCountry = manufacturedCountry;
    }
}
