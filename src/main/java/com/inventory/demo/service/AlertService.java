package com.inventory.demo.service;

import com.inventory.demo.dto.AlertResponse;
import com.inventory.demo.entity.Inventory;
import com.inventory.demo.entity.Product;
import com.inventory.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<AlertResponse> getLowStockAlerts() {

        List<Inventory> inventoryList = inventoryRepository.findAll();
        List<AlertResponse> alerts = new ArrayList<>();

        for (Inventory inv : inventoryList) {

            Product product = inv.getProduct();

            if (inv.getQuantity() < product.getLowStockThreshold()) {

                int dailyUsage = 1;
                Integer daysUntilStockout =
                        dailyUsage == 0 ? null : inv.getQuantity() / dailyUsage;

                AlertResponse alert = new AlertResponse(
                        product.getId(),
                        product.getName(),
                        product.getSku(),
                        inv.getWarehouseId(),
                        inv.getQuantity(),
                        product.getLowStockThreshold(),
                        daysUntilStockout
                );

                alerts.add(alert);
            }
        }

        return alerts;
    }
}