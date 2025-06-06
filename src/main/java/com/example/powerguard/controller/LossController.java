package com.example.powerguard.controller;

import com.example.powerguard.model.Loss;
import com.example.powerguard.service.LossService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/losses")
@Tag(name = "Perdas", description = "APIs para gerenciamento de perdas financeiras")
@SecurityRequirement(name = "bearerAuth")
public class LossController {
    private final LossService service;

    public LossController(LossService service) {
        this.service = service;
    }

    @Operation(summary = "Criar perda", description = "Registra uma nova perda financeira")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Perda registrada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping
    public ResponseEntity<Loss> createLoss(@RequestBody Loss loss) {
        try {
            Loss saved = service.saveLoss(loss);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Listar perdas", description = "Retorna todas as perdas registradas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de perdas retornada com sucesso"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping
    public ResponseEntity<List<Loss>> getAllLosses() {
        try {
            List<Loss> losses = service.getAllLosses();
            return ResponseEntity.ok(losses);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
} 