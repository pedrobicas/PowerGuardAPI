package com.example.powerguard.controller;

import com.example.powerguard.model.Loss;
import com.example.powerguard.service.LossService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/losses")
@CrossOrigin(origins = {"http://localhost:8081", "http://127.0.0.1:8081"}, 
             allowedHeaders = "*",
             methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
             allowCredentials = "true")
public class LossController {
    private final LossService service;

    public LossController(LossService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Loss> createLoss(@RequestBody Loss loss) {
        try {
            Loss saved = service.saveLoss(loss);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Loss>> getAllLosses() {
        try {
            List<Loss> losses = service.getAllLosses();
            return ResponseEntity.ok(losses);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
} 