package com.alberti.kata.service;

import com.alberti.kata.dto.BeerPatchRequest;
import com.alberti.kata.dto.BeerRequest;
import com.alberti.kata.dto.BeerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BeerService {
    
    List<BeerResponse> findAll();
    
    Page<BeerResponse> findAll(Pageable pageable);
    
    BeerResponse findById(Integer id);
    
    BeerResponse create(BeerRequest request);
    
    BeerResponse update(Integer id, BeerRequest request);
    
    BeerResponse patch(Integer id, BeerPatchRequest request);
    
    void delete(Integer id);
    
    BeerResponse uploadImage(Integer id, MultipartFile file);
}
