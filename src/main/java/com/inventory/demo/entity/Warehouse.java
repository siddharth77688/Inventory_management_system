package com.inventory.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // For now, just storing companyId (can be upgraded later)
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    // Constructors
    public Warehouse() {}

    public Warehouse(String name, Long companyId) {
        this.name = name;
        this.companyId = companyId;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}