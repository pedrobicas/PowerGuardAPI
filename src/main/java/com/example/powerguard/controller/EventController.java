package com.example.powerguard.controller;

import com.example.powerguard.model.Event;
import com.example.powerguard.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@Tag(name = "Eventos", description = "APIs para gerenciamento de eventos de falhas de energia e alertas de segurança")
@SecurityRequirement(name = "bearerAuth")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @Operation(summary = "Registrar falha de energia", description = "Registra um novo evento de falha de energia")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Evento registrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
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

    @Operation(summary = "Registrar alerta de segurança", description = "Registra um novo alerta de segurança")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Alerta registrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
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

    @Operation(summary = "Simular ataque", description = "Simula um ataque cibernético para testes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Simulação registrada com sucesso"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping("/simular-ataque")
    public ResponseEntity<Event> simularAtaque() {
        try {
            Event saved = service.simularAtaque();
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Listar eventos", description = "Retorna a lista de eventos, opcionalmente filtrados por tipo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de eventos retornada com sucesso"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
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