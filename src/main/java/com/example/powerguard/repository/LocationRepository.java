package com.example.powerguard.repository;

import com.example.powerguard.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
} 