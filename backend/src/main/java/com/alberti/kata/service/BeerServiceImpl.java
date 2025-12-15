package com.alberti.kata.service;

import com.alberti.kata.dto.BeerPatchRequest;
import com.alberti.kata.dto.BeerRequest;
import com.alberti.kata.dto.BeerResponse;
import com.alberti.kata.entity.Beer;
import com.alberti.kata.exception.ResourceNotFoundException;
import com.alberti.kata.mapper.BeerMapper;
import com.alberti.kata.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;
    private final FileStorageService fileStorageService;

    @Override
    @Transactional(readOnly = true)
    public List<BeerResponse> findAll() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BeerResponse> findAll(Pageable pageable) {
        return beerRepository.findAll(pageable)
                .map(beerMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public BeerResponse findById(Integer id) {
        return beerRepository.findById(id)
                .map(beerMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Cerveza no encontrada con ID: " + id));
    }

    @Override
    @Transactional
    public BeerResponse create(BeerRequest request) {
        return beerMapper.toResponse(
                beerRepository.save(beerMapper.toEntity(request))
        );
    }

    @Override
    @Transactional
    public BeerResponse update(Integer id, BeerRequest request) {
        Beer beer = beerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cerveza no encontrada con ID: " + id));
        
        beerMapper.updateEntity(beer, request);
        return beerMapper.toResponse(beerRepository.save(beer));
    }

    @Override
    @Transactional
    public BeerResponse patch(Integer id, BeerPatchRequest request) {
        Beer beer = beerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cerveza no encontrada con ID: " + id));
        
        if (request.breweryId() != null) beer.setBreweryId(request.breweryId());
        if (request.name() != null) beer.setName(request.name());
        if (request.catId() != null) beer.setCatId(request.catId());
        if (request.styleId() != null) beer.setStyleId(request.styleId());
        if (request.abv() != null) beer.setAbv(request.abv());
        if (request.ibu() != null) beer.setIbu(request.ibu());
        if (request.srm() != null) beer.setSrm(request.srm());
        if (request.upc() != null) beer.setUpc(request.upc());
        if (request.filepath() != null) beer.setFilepath(request.filepath());
        if (request.descript() != null) beer.setDescript(request.descript());
        
        beer.setLastMod(LocalDateTime.now());
        return beerMapper.toResponse(beerRepository.save(beer));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (!beerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cerveza no encontrada con ID: " + id);
        }
        beerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public BeerResponse uploadImage(Integer id, MultipartFile file) {
        Beer beer = beerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cerveza no encontrada con ID: " + id));
        
        // Eliminar la imagen anterior si existe
        if (beer.getFilepath() != null && !beer.getFilepath().isBlank()) {
            fileStorageService.deleteFile(beer.getFilepath());
        }
        
        // Guardar la nueva imagen
        String filename = fileStorageService.storeFile(file, id);
        beer.setFilepath(filename);
        beer.setLastMod(LocalDateTime.now());
        
        return beerMapper.toResponse(beerRepository.save(beer));
    }
}
