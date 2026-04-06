package com.inventory.demo.controller;

import com.inventory.demo.dto.ProductRequest;
import com.inventory.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.inventory.demo.dto.ApiResponse;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest request) {

        Long productId = productService.createProduct(
                request.getName(),
                request.getSku(),
                request.getPrice(),
                request.getWarehouseId(),
                request.getInitialQuantity()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse("Product created successfully", productId)
        );
    }
}