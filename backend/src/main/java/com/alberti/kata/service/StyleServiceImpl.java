package com.alberti.kata.service;

import com.alberti.kata.dto.StyleResponse;
import com.alberti.kata.exception.ResourceNotFoundException;
import com.alberti.kata.mapper.StyleMapper;
import com.alberti.kata.repository.StyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StyleServiceImpl implements StyleService {

    private final StyleRepository styleRepository;
    private final StyleMapper styleMapper;

    @Override
    public List<StyleResponse> findAll() {
        return styleRepository.findAll().stream()
                .map(styleMapper::toResponse)
                .toList();
    }

    @Override
    public StyleResponse findById(Integer id) {
        return styleRepository.findById(id)
                .map(styleMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Style not found with id: " + id));
    }
}
