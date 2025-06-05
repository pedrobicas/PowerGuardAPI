package com.example.powerguard.controller;

import com.example.powerguard.model.Duration;
import com.example.powerguard.service.DurationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/durations")
public class DurationController {
    private final DurationService service;

    public DurationController(DurationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Duration> createDuration(@RequestBody Duration duration) {
        try {
            Duration saved = service.saveDuration(duration);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Duration>> getAllDurations() {
        try {
            List<Duration> durations = service.getAllDurations();
            return ResponseEntity.ok(durations);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
} 