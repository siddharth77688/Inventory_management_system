package com.inventory.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AlertWrapper {

    private List<AlertResponse> alerts;
    private int totalAlerts;
}