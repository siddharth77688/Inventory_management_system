package com.inventory.demo.controller;

import com.inventory.demo.dto.AlertResponse;
import com.inventory.demo.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.inventory.demo.dto.AlertWrapper;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping("/{companyId}/alerts/low-stock")
    public ResponseEntity<?> getLowStockAlerts(@PathVariable Long companyId) {

        // NOTE: currently companyId is not used (can be improved later)
        List<AlertResponse> alerts = alertService.getLowStockAlerts();

        return ResponseEntity.ok(
                new AlertWrapper(alerts, alerts.size())
        );
    }
}