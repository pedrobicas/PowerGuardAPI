package com.example.powerguard.controller;

import com.example.powerguard.dto.EventRequestDTO;
import com.example.powerguard.dto.EventResponseDTO;
import com.example.powerguard.model.Event;
import com.example.powerguard.service.EventService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/eventos")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping("/falha")
    public ResponseEntity<EventResponseDTO> registrarFalhaEnergia(@Valid @RequestBody EventRequestDTO dto) {
        dto.setTipo("FALHA_ENERGIA");
        Event saved = service.salvarEvento(dto);
        return new ResponseEntity<>(toResponseDTO(saved), HttpStatus.CREATED);
    }

    @PostMapping("/alerta")
    public ResponseEntity<EventResponseDTO> registrarAlertaSeguranca(@Valid @RequestBody EventRequestDTO dto) {
        dto.setTipo("ALERTA_SEGURANCA");
        Event saved = service.salvarEvento(dto);
        return new ResponseEntity<>(toResponseDTO(saved), HttpStatus.CREATED);
    }

    @PostMapping("/simular-ataque")
    public ResponseEntity<EventResponseDTO> simularAtaque() {
        Event saved = service.simularAtaque();
        return new ResponseEntity<>(toResponseDTO(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> listarEventos() {
        List<Event> eventos = service.listarEventos();
        List<EventResponseDTO> dtoList = eventos.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    private EventResponseDTO toResponseDTO(Event event) {
        EventResponseDTO dto = new EventResponseDTO();
        dto.setId(event.getId());
        dto.setTipo(event.getTipo());
        dto.setDescricao(event.getDescricao());
        dto.setLocalizacao(event.getLocalizacao());
        dto.setTimestamp(event.getTimestamp());
        return dto;
    }
}