package com.project.quix.dashboard.controller;

import com.project.quix.dashboard.model.DashboardService;
import com.project.quix.dashboard.model.DateIntervalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;
    @PostMapping("/api/dashboard")
    public ResponseEntity<?> dashboardBetween(@RequestBody DateIntervalDTO dateIntervalDTO){
        if (dateIntervalDTO.getDate1() == null){
            dateIntervalDTO.setDate1(LocalDateTime.of(2000,01,1,1,1));
        }
        if (dateIntervalDTO.getDate2() == null){
            dateIntervalDTO.setDate2(LocalDateTime.of(3000,01,1,1,1));
        }
        return ResponseEntity.ok(dashboardService.getDashboard(dateIntervalDTO));
    }
}
