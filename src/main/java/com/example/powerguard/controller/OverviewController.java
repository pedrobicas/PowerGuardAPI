package com.example.powerguard.controller;

import com.example.powerguard.service.OverviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/overview")
@Tag(name = "Visão Geral", description = "APIs para obter visão geral do sistema")
@SecurityRequirement(name = "bearerAuth")
public class OverviewController {

    private final OverviewService service;

    public OverviewController(OverviewService service) {
        this.service = service;
    }

    @Operation(
        summary = "Obter visão geral",
        description = "Retorna um resumo com estatísticas e informações gerais do sistema, incluindo total de eventos, áreas afetadas, duração total das interrupções e prejuízos"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Visão geral retornada com sucesso"),
        @ApiResponse(responseCode = "401", description = "Não autorizado"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping
    public ResponseEntity<Map<String, Object>> getOverview() {
        try {
            Map<String, Object> overview = service.getOverview();
            return ResponseEntity.ok(overview);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
} 