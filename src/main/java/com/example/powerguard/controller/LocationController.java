package com.example.powerguard.controller;

import com.example.powerguard.model.Location;
import com.example.powerguard.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@Tag(name = "Localizações", description = "APIs para gerenciamento de localizações")
@SecurityRequirement(name = "bearerAuth")
public class LocationController {
    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @Operation(summary = "Criar localização", description = "Registra uma nova localização")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Localização registrada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        try {
            Location saved = service.saveLocation(location);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Listar localizações", description = "Retorna todas as localizações registradas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de localizações retornada com sucesso"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        try {
            List<Location> locations = service.getAllLocations();
            return ResponseEntity.ok(locations);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
} 