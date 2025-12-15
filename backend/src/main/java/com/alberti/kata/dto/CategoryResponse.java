package com.alberti.kata.dto;

import java.time.LocalDateTime;

public record CategoryResponse(
    Integer id,
    String catName,
    LocalDateTime lastMod
) {}
