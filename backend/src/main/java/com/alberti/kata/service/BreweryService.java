package com.alberti.kata.service;

import com.alberti.kata.dto.BreweryResponse;

import java.util.List;

public interface BreweryService {
    
    List<BreweryResponse> findAll();
    
    BreweryResponse findById(Integer id);
}
