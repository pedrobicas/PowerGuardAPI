package com.example.powerguard.controller;

import com.example.powerguard.model.Duration;
import com.example.powerguard.service.DurationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/durations")
@Tag(name = "Durações", description = "APIs para gerenciamento de durações de eventos")
@SecurityRequirement(name = "bearerAuth")
public class DurationController {
    private final DurationService service;

    public DurationController(DurationService service) {
        this.service = service;
    }

    @Operation(summary = "Criar duração", description = "Registra uma nova duração de evento")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Duração registrada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping
    public ResponseEntity<Duration> createDuration(@RequestBody Duration duration) {
        try {
            Duration saved = service.saveDuration(duration);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Listar durações", description = "Retorna todas as durações registradas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de durações retornada com sucesso"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping
    public ResponseEntity<List<Duration>> getAllDurations() {
        try {
            List<Duration> durations = service.getAllDurations();
            return ResponseEntity.ok(durations);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
} 