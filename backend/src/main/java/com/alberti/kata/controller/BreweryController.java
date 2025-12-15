package com.alberti.kata.controller;

import com.alberti.kata.dto.BreweryResponse;
import com.alberti.kata.service.BreweryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BreweryController {

    private final BreweryService breweryService;

    @GetMapping("/breweries")
    public ResponseEntity<List<BreweryResponse>> getAllBreweries() {
        return ResponseEntity.ok(breweryService.findAll());
    }

    @GetMapping("/brewerie/{id}")
    public ResponseEntity<BreweryResponse> getBreweryById(@PathVariable Integer id) {
        return ResponseEntity.ok(breweryService.findById(id));
    }
}
