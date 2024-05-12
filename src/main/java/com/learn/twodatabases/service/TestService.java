package com.learn.twodatabases.service;

import com.learn.twodatabases.entity.customerdb.Customer;
import com.learn.twodatabases.entity.productdb.Product;
import com.learn.twodatabases.repository.customerdb.CustomerRepository;
import com.learn.twodatabases.repository.productdb.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public TestService(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}
