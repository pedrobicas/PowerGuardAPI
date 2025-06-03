package com.example.powerguard.service;

import com.example.powerguard.model.Duration;
import com.example.powerguard.repository.DurationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DurationService {
    private final DurationRepository repository;

    public DurationService(DurationRepository repository) {
        this.repository = repository;
    }

    public Duration saveDuration(Duration duration) {
        return repository.save(duration);
    }

    public List<Duration> getAllDurations() {
        return repository.findAll();
    }
} 