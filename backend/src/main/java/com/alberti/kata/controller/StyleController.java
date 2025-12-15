package com.alberti.kata.controller;

import com.alberti.kata.dto.StyleResponse;
import com.alberti.kata.service.StyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StyleController {

    private final StyleService styleService;

    @GetMapping("/styles")
    public ResponseEntity<List<StyleResponse>> getAllStyles() {
        return ResponseEntity.ok(styleService.findAll());
    }

    @GetMapping("/style/{id}")
    public ResponseEntity<StyleResponse> getStyleById(@PathVariable Integer id) {
        return ResponseEntity.ok(styleService.findById(id));
    }
}
