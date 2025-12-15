package com.alberti.kata.dto;

import java.time.LocalDateTime;

public record BreweryResponse(
    Integer id,
    String name,
    String address1,
    String address2,
    String city,
    String state,
    String code,
    String country,
    String phone,
    String website,
    String filepath,
    String descript,
    Integer addUser,
    LocalDateTime lastMod
) {}
