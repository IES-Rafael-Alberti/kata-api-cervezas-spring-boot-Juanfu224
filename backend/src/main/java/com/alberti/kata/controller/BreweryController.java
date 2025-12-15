package com.alberti.kata.controller;

import com.alberti.kata.dto.BreweryResponse;
import com.alberti.kata.service.BreweryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Brewery", description = "API de consulta de cerveceras")
public class BreweryController {

    private final BreweryService breweryService;

    @GetMapping("/breweries")
    @Operation(summary = "Listar todas las cerveceras", description = "Obtiene la lista completa de cerveceras")
    @ApiResponse(responseCode = "200", description = "Lista de cerveceras obtenida exitosamente")
    public ResponseEntity<List<BreweryResponse>> getAllBreweries() {
        return ResponseEntity.ok(breweryService.findAll());
    }

    @GetMapping("/brewerie/{id}")
    @Operation(summary = "Obtener cervecera por ID", description = "Obtiene una cervecera específica por su ID")
    @ApiResponse(responseCode = "200", description = "Cervecera encontrada")
    @ApiResponse(responseCode = "404", description = "Cervecera no encontrada")
    public ResponseEntity<BreweryResponse> getBreweryById(@PathVariable Integer id) {
        return ResponseEntity.ok(breweryService.findById(id));
    }
}
