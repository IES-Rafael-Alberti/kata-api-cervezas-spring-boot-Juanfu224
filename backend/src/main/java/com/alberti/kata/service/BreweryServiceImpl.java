package com.alberti.kata.service;

import com.alberti.kata.dto.BreweryResponse;
import com.alberti.kata.exception.ResourceNotFoundException;
import com.alberti.kata.mapper.BreweryMapper;
import com.alberti.kata.repository.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BreweryServiceImpl implements BreweryService {

    private final BreweryRepository breweryRepository;
    private final BreweryMapper breweryMapper;

    @Override
    public List<BreweryResponse> findAll() {
        return breweryRepository.findAll().stream()
                .map(breweryMapper::toResponse)
                .toList();
    }

    @Override
    public BreweryResponse findById(Integer id) {
        return breweryRepository.findById(id)
                .map(breweryMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Brewery not found with id: " + id));
    }
}
