package com.inventory.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertResponse {

    private Long productId;
    private String productName;
    private String sku;
    private Long warehouseId;
    private Integer currentStock;
    private Integer threshold;
    private Integer daysUntilStockout;
}