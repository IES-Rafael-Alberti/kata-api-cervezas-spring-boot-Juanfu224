package com.alberti.kata.controller;

import com.alberti.kata.dto.StyleResponse;
import com.alberti.kata.service.StyleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Style", description = "API de consulta de estilos")
public class StyleController {

    private final StyleService styleService;

    @GetMapping("/styles")
    @Operation(summary = "Listar todos los estilos", description = "Obtiene la lista completa de estilos")
    @ApiResponse(responseCode = "200", description = "Lista de estilos obtenida exitosamente")
    public ResponseEntity<List<StyleResponse>> getAllStyles() {
        return ResponseEntity.ok(styleService.findAll());
    }

    @GetMapping("/style/{id}")
    @Operation(summary = "Obtener estilo por ID", description = "Obtiene un estilo específico por su ID")
    @ApiResponse(responseCode = "200", description = "Estilo encontrado")
    @ApiResponse(responseCode = "404", description = "Estilo no encontrado")
    public ResponseEntity<StyleResponse> getStyleById(@PathVariable Integer id) {
        return ResponseEntity.ok(styleService.findById(id));
    }
}
