package com.example.powerguard.controller;

import com.example.powerguard.service.OverviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/overview")
@CrossOrigin(origins = {"http://localhost:8081", "http://127.0.0.1:8081"}, 
             allowedHeaders = "*",
             methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
             allowCredentials = "true")
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