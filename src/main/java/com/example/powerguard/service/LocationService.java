package com.example.powerguard.service;

import com.example.powerguard.model.Location;
import com.example.powerguard.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public Location saveLocation(Location location) {
        return repository.save(location);
    }

    public List<Location> getAllLocations() {
        return repository.findAll();
    }
} 