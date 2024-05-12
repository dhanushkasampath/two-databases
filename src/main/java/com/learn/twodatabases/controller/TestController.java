package com.learn.twodatabases.controller;

import com.learn.twodatabases.entity.Customer;
import com.learn.twodatabases.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(Arrays.asList(new Product()));
    }

    @GetMapping("/api/customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(Arrays.asList(new Customer()));
    }
}
