package com.alberti.kata.dto;

import java.time.LocalDateTime;

public record BeerResponse(
        Integer id,
        Integer breweryId,
        String name,
        Integer catId,
        Integer styleId,
        Float abv,
        Float ibu,
        Float srm,
        Integer upc,
        String filepath,
        String descript,
        Integer addUser,
        LocalDateTime lastMod
) {}
