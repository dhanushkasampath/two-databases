package com.learn.twodatabases.repository.customerdb;

import com.learn.twodatabases.entity.customerdb.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
