package com.example.powerguard.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/recommendations")
@Tag(name = "Recomendações", description = "APIs para obter recomendações e números de emergência")
@SecurityRequirement(name = "bearerAuth")
public class RecommendationController {

    @Operation(summary = "Obter recomendações", description = "Retorna recomendações para diferentes situações de falta de energia")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Recomendações retornadas com sucesso"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getRecommendations() {
        List<Map<String, Object>> recommendations = new ArrayList<>();
        
        Map<String, Object> antes = new HashMap<>();
        antes.put("title", "Antes da Falta de Energia");
        antes.put("items", Arrays.asList(
            "Mantenha uma lanterna e pilhas extras em local de fácil acesso",
            "Tenha um rádio portátil para receber informações",
            "Mantenha o celular sempre carregado",
            "Tenha uma reserva de água potável",
            "Considere ter um gerador de energia para casos de emergência"
        ));
        recommendations.add(antes);

        Map<String, Object> durante = new HashMap<>();
        durante.put("title", "Durante a Falta de Energia");
        durante.put("items", Arrays.asList(
            "Desligue todos os aparelhos elétricos para evitar danos quando a energia voltar",
            "Mantenha a geladeira e freezer fechados para preservar os alimentos",
            "Use lanternas em vez de velas para evitar riscos de incêndio",
            "Mantenha-se informado através do rádio ou celular",
            "Evite abrir portas e janelas desnecessariamente para manter a temperatura"
        ));
        recommendations.add(durante);

        Map<String, Object> apos = new HashMap<>();
        apos.put("title", "Após a Falta de Energia");
        apos.put("items", Arrays.asList(
            "Verifique se todos os aparelhos estão funcionando corretamente",
            "Descarte alimentos que possam ter estragado",
            "Verifique se há danos na instalação elétrica",
            "Registre o tempo de duração da falta de energia",
            "Comunique à concessionária sobre a ocorrência"
        ));
        recommendations.add(apos);

        Map<String, Object> prevencao = new HashMap<>();
        prevencao.put("title", "Prevenção de Danos");
        prevencao.put("items", Arrays.asList(
            "Instale um filtro de linha para proteger equipamentos eletrônicos",
            "Mantenha a instalação elétrica em dia",
            "Tenha um plano de contingência para sua empresa",
            "Faça backup regular dos dados importantes",
            "Considere ter um sistema de energia alternativa"
        ));
        recommendations.add(prevencao);

        return ResponseEntity.ok(recommendations);
    }

    @Operation(summary = "Obter números de emergência", description = "Retorna lista de números de emergência importantes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Números de emergência retornados com sucesso"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @GetMapping("/emergency")
    public ResponseEntity<Map<String, List<String>>> getEmergencyNumbers() {
        Map<String, List<String>> emergencyNumbers = new HashMap<>();
        emergencyNumbers.put("numbers", Arrays.asList(
            "Defesa Civil: 199",
            "Bombeiros: 193",
            "Polícia: 190",
            "SAMU: 192"
        ));

        return ResponseEntity.ok(emergencyNumbers);
    }
} 