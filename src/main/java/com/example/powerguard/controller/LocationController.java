package com.example.powerguard.controller;

import com.example.powerguard.model.Location;
import com.example.powerguard.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        try {
            Location saved = service.saveLocation(location);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        try {
            List<Location> locations = service.getAllLocations();
            return ResponseEntity.ok(locations);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
} 