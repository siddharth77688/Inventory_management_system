package com.inventory.demo.repository;

import com.inventory.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query method
    Optional<Product> findBySku(String sku);
}