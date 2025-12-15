package com.alberti.kata.controller;

import com.alberti.kata.dto.BeerPatchRequest;
import com.alberti.kata.dto.BeerRequest;
import com.alberti.kata.dto.BeerResponse;
import com.alberti.kata.service.BeerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Tag(name = "Beer", description = "API de gestión de cervezas")
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/beers")
    @Operation(summary = "Listar todas las cervezas", description = "Obtiene todas las cervezas o con paginación si se proporcionan parámetros")
    @ApiResponse(responseCode = "200", description = "Lista de cervezas obtenida exitosamente")
    public ResponseEntity<?> getAllBeers(
            @Parameter(hidden = true) @PageableDefault(size = 20) Pageable pageable,
            @RequestParam(required = false) Boolean paginated) {
        
        if (Boolean.TRUE.equals(paginated)) {
            Page<BeerResponse> page = beerService.findAll(pageable);
            return ResponseEntity.ok(page);
        }
        return ResponseEntity.ok(beerService.findAll());
    }

    @GetMapping("/beer/{id}")
    @Operation(summary = "Obtener cerveza por ID", description = "Obtiene una cerveza específica por su ID")
    @ApiResponse(responseCode = "200", description = "Cerveza encontrada")
    @ApiResponse(responseCode = "404", description = "Cerveza no encontrada")
    public ResponseEntity<BeerResponse> getBeerById(@PathVariable Integer id) {
        return ResponseEntity.ok(beerService.findById(id));
    }

    @PostMapping("/beer")
    @Operation(summary = "Crear nueva cerveza", description = "Crea una nueva cerveza en el sistema")
    @ApiResponse(responseCode = "201", description = "Cerveza creada exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    public ResponseEntity<BeerResponse> createBeer(@Valid @RequestBody BeerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(beerService.create(request));
    }

    @PutMapping("/beer/{id}")
    @Operation(summary = "Actualizar cerveza", description = "Actualiza completamente una cerveza existente")
    @ApiResponse(responseCode = "200", description = "Cerveza actualizada exitosamente")
    @ApiResponse(responseCode = "404", description = "Cerveza no encontrada")
    public ResponseEntity<BeerResponse> updateBeer(
            @PathVariable Integer id,
            @Valid @RequestBody BeerRequest request) {
        return ResponseEntity.ok(beerService.update(id, request));
    }

    @PatchMapping("/beer/{id}")
    @Operation(summary = "Actualizar parcialmente cerveza", description = "Actualiza solo los campos proporcionados de una cerveza")
    @ApiResponse(responseCode = "200", description = "Cerveza actualizada exitosamente")
    @ApiResponse(responseCode = "404", description = "Cerveza no encontrada")
    public ResponseEntity<BeerResponse> patchBeer(
            @PathVariable Integer id,
            @RequestBody BeerPatchRequest request) {
        return ResponseEntity.ok(beerService.patch(id, request));
    }

    @DeleteMapping("/beer/{id}")
    @Operation(summary = "Eliminar cerveza", description = "Elimina una cerveza del sistema")
    @ApiResponse(responseCode = "204", description = "Cerveza eliminada exitosamente")
    @ApiResponse(responseCode = "404", description = "Cerveza no encontrada")
    public ResponseEntity<Void> deleteBeer(@PathVariable Integer id) {
        beerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/beer/{id}/image")
    @Operation(summary = "Subir imagen de cerveza", description = "Sube una imagen para una cerveza específica")
    @ApiResponse(responseCode = "200", description = "Imagen subida exitosamente")
    @ApiResponse(responseCode = "404", description = "Cerveza no encontrada")
    @ApiResponse(responseCode = "400", description = "Archivo inválido")
    public ResponseEntity<BeerResponse> uploadImage(
            @PathVariable Integer id,
            @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(beerService.uploadImage(id, file));
    }
}
