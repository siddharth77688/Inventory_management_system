package com.inventory.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "inventory",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"product_id", "warehouse_id"})
    }
)
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many inventory records → One product
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // For now keep warehouse as ID (we'll improve later)
    @Column(name = "warehouse_id", nullable = false)
    private Long warehouseId;

    @Column(nullable = false)
    private Integer quantity = 0;

    // Constructors
    public Inventory() {}

    public Inventory(Product product, Long warehouseId, Integer quantity) {
        this.product = product;
        this.warehouseId = warehouseId;
        this.quantity = quantity;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}