package com.inventory.demo.repository;

import com.inventory.demo.entity.Inventory;
import com.inventory.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    // Find inventory by product
    List<Inventory> findByProduct(Product product);

    //  Used for low stock alerts later
    List<Inventory> findByQuantityLessThan(Integer threshold);
}