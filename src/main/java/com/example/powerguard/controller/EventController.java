package com.example.powerguard.controller;

import com.example.powerguard.model.Event;
import com.example.powerguard.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping("/falha")
    public ResponseEntity<Event> registrarFalhaEnergia(@RequestBody Event event) {
        try {
            if (event.getDescricao() == null || event.getDescricao().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            event.setTipo("FALHA_ENERGIA");
            Event saved = service.salvarEvento(event);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/alerta")
    public ResponseEntity<Event> registrarAlertaSeguranca(@RequestBody Event event) {
        try {
            if (event.getDescricao() == null || event.getDescricao().trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            event.setTipo("ALERTA_SEGURANCA");
            Event saved = service.salvarEvento(event);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/simular-ataque")
    public ResponseEntity<Event> simularAtaque() {
        try {
            Event saved = service.simularAtaque();
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Event>> listarEventos(
            @RequestParam(required = false) String tipo) {
        try {
            List<Event> eventos = service.listarEventos(tipo);
            return ResponseEntity.ok(eventos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}