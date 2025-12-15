package com.alberti.kata.controller;

import com.alberti.kata.dto.BeerPatchRequest;
import com.alberti.kata.dto.BeerRequest;
import com.alberti.kata.dto.BeerResponse;
import com.alberti.kata.service.BeerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/beers")
    public ResponseEntity<List<BeerResponse>> getAllBeers() {
        return ResponseEntity.ok(beerService.findAll());
    }

    @GetMapping("/beer/{id}")
    public ResponseEntity<BeerResponse> getBeerById(@PathVariable Integer id) {
        return ResponseEntity.ok(beerService.findById(id));
    }

    @PostMapping("/beer")
    public ResponseEntity<BeerResponse> createBeer(@Valid @RequestBody BeerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(beerService.create(request));
    }

    @PutMapping("/beer/{id}")
    public ResponseEntity<BeerResponse> updateBeer(
            @PathVariable Integer id,
            @Valid @RequestBody BeerRequest request) {
        return ResponseEntity.ok(beerService.update(id, request));
    }

    @PatchMapping("/beer/{id}")
    public ResponseEntity<BeerResponse> patchBeer(
            @PathVariable Integer id,
            @RequestBody BeerPatchRequest request) {
        return ResponseEntity.ok(beerService.patch(id, request));
    }

    @DeleteMapping("/beer/{id}")
    public ResponseEntity<Void> deleteBeer(@PathVariable Integer id) {
        beerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
