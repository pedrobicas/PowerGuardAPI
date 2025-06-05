package com.example.powerguard.controller;

import com.example.powerguard.service.OverviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/overview")
public class OverviewController {

    private final OverviewService service;

    public OverviewController(OverviewService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getOverview() {
        try {
            Map<String, Object> overview = service.getOverview();
            return ResponseEntity.ok(overview);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
} 