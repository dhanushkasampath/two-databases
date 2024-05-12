package com.learn.twodatabases.controller;

import com.learn.twodatabases.entity.Customer;
import com.learn.twodatabases.entity.Product;
import com.learn.twodatabases.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(testService.getProducts());
    }

    @GetMapping("/api/customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(testService.getCustomers());
    }
}
