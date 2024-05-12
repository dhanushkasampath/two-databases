package com.learn.twodatabases.repository.productdb;

import com.learn.twodatabases.entity.productdb.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
