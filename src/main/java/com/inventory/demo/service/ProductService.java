package com.inventory.demo.service;

import com.inventory.demo.entity.Inventory;
import com.inventory.demo.entity.Product;
import com.inventory.demo.repository.InventoryRepository;
import com.inventory.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional
    public Long createProduct(String name, String sku, BigDecimal price,
                              Long warehouseId, Integer initialQuantity) {

        //  1. Check SKU uniqueness
        if (productRepository.findBySku(sku).isPresent()) {
            throw new RuntimeException("SKU already exists");
        }

        // 2. Create Product
        Product product = new Product();
        product.setName(name);
        product.setSku(sku);
        product.setPrice(price);

        productRepository.save(product);

        // 3. Create Inventory (multi-warehouse support)
        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventory.setWarehouseId(warehouseId);
        inventory.setQuantity(initialQuantity != null ? initialQuantity : 0);

        inventoryRepository.save(inventory);

        return product.getId();
    }
}