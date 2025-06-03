package com.example.powerguard.service;

import com.example.powerguard.model.Event;
import com.example.powerguard.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public Event salvarEvento(Event event) {
        event.setTimestamp(LocalDateTime.now());
        return repository.save(event);
    }

    public List<Event> listarEventos(String tipo) {
        if (tipo != null && !tipo.isEmpty()) {
            return repository.findByTipo(tipo);
        }
        return repository.findAll();
    }

    public Event simularAtaque() {
        Event ataque = new Event();
        ataque.setTipo("ATAQUE_SIMULADO");
        ataque.setDescricao("Simulação de ataque cibernético");
        ataque.setLocalizacao("Sistema Interno");
        ataque.setTimestamp(LocalDateTime.now());
        return repository.save(ataque);
    }
}