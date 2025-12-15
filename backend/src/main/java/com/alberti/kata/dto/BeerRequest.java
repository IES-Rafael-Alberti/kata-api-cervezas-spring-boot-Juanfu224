package com.alberti.kata.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record BeerRequest(
        @Positive(message = "El ID de la cervecería debe ser positivo")
        Integer breweryId,
        
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        
        @Positive(message = "El ID de categoría debe ser positivo")
        Integer catId,
        
        @Positive(message = "El ID de estilo debe ser positivo")
        Integer styleId,
        
        Float abv,
        Float ibu,
        Float srm,
        Integer upc,
        String filepath,
        String descript
) {}
