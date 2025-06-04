package com.example.powerguard.service;

import com.example.powerguard.model.Event;
import com.example.powerguard.model.Location;
import com.example.powerguard.model.Duration;
import com.example.powerguard.model.Loss;
import com.example.powerguard.repository.EventRepository;
import com.example.powerguard.repository.LocationRepository;
import com.example.powerguard.repository.DurationRepository;
import com.example.powerguard.repository.LossRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OverviewService {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;
    private final DurationRepository durationRepository;
    private final LossRepository lossRepository;

    public OverviewService(
            EventRepository eventRepository,
            LocationRepository locationRepository,
            DurationRepository durationRepository,
            LossRepository lossRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
        this.durationRepository = durationRepository;
        this.lossRepository = lossRepository;
    }

    public Map<String, Object> getOverview() {
        Map<String, Object> overview = new HashMap<>();

        // Total de eventos
        overview.put("totalEvents", eventRepository.count());

        // Áreas únicas afetadas
        long uniqueAreas = locationRepository.findAll().stream()
                .map(location -> location.getNeighborhood() + ", " + location.getCity())
                .collect(Collectors.toSet())
                .size();
        overview.put("affectedAreas", uniqueAreas);

        // Duração total das interrupções
        int totalDuration = durationRepository.findAll().stream()
                .mapToInt(duration -> duration.getActualDuration() != null ? duration.getActualDuration() : 0)
                .sum();
        overview.put("totalDuration", totalDuration);

        // Prejuízos totais
        double totalLosses = lossRepository.findAll().stream()
                .mapToDouble(loss -> loss.getEstimatedLoss() != null ? loss.getEstimatedLoss() : 0.0)
                .sum();
        overview.put("totalLosses", totalLosses);

        // Eventos recentes
        overview.put("recentEvents", eventRepository.findAll().stream()
                .sorted((e1, e2) -> e2.getTimestamp().compareTo(e1.getTimestamp()))
                .limit(5)
                .collect(Collectors.toList()));

        return overview;
    }
} 