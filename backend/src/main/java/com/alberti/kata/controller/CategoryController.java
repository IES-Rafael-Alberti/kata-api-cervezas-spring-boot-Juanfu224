package com.alberti.kata.controller;

import com.alberti.kata.dto.CategoryResponse;
import com.alberti.kata.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Category", description = "API de consulta de categorías")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    @Operation(summary = "Listar todas las categorías", description = "Obtiene la lista completa de categorías")
    @ApiResponse(responseCode = "200", description = "Lista de categorías obtenida exitosamente")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/categorie/{id}")
    @Operation(summary = "Obtener categoría por ID", description = "Obtiene una categoría específica por su ID")
    @ApiResponse(responseCode = "200", description = "Categoría encontrada")
    @ApiResponse(responseCode = "404", description = "Categoría no encontrada")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }
}
