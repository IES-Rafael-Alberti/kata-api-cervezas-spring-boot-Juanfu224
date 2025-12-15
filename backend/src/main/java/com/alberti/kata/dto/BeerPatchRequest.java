package com.alberti.kata.dto;

public record BeerPatchRequest(
        Integer breweryId,
        String name,
        Integer catId,
        Integer styleId,
        Float abv,
        Float ibu,
        Float srm,
        Integer upc,
        String filepath,
        String descript
) {}
