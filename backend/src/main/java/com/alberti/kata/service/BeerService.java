package com.alberti.kata.service;

import com.alberti.kata.dto.BeerPatchRequest;
import com.alberti.kata.dto.BeerRequest;
import com.alberti.kata.dto.BeerResponse;

import java.util.List;

public interface BeerService {
    
    List<BeerResponse> findAll();
    
    BeerResponse findById(Integer id);
    
    BeerResponse create(BeerRequest request);
    
    BeerResponse update(Integer id, BeerRequest request);
    
    BeerResponse patch(Integer id, BeerPatchRequest request);
    
    void delete(Integer id);
}
