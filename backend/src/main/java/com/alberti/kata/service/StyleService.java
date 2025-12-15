package com.alberti.kata.service;

import com.alberti.kata.dto.StyleResponse;

import java.util.List;

public interface StyleService {
    
    List<StyleResponse> findAll();
    
    StyleResponse findById(Integer id);
}
