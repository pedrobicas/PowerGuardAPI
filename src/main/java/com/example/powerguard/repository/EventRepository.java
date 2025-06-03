package com.example.powerguard.repository;

import com.example.powerguard.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByTipo(String tipo);
}