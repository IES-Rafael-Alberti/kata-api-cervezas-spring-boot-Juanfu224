package com.alberti.kata.dto;

import java.time.LocalDateTime;

public record StyleResponse(
    Integer id,
    Integer catId,
    String styleName,
    LocalDateTime lastMod
) {}
