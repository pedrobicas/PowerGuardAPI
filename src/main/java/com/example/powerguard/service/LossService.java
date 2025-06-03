package com.example.powerguard.service;

import com.example.powerguard.model.Loss;
import com.example.powerguard.repository.LossRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LossService {
    private final LossRepository repository;

    public LossService(LossRepository repository) {
        this.repository = repository;
    }

    public Loss saveLoss(Loss loss) {
        return repository.save(loss);
    }

    public List<Loss> getAllLosses() {
        return repository.findAll();
    }
} 