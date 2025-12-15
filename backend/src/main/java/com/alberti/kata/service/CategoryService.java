package com.alberti.kata.service;

import com.alberti.kata.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    
    List<CategoryResponse> findAll();
    
    CategoryResponse findById(Integer id);
}
