package com.alberti.kata.mapper;

import com.alberti.kata.dto.BeerRequest;
import com.alberti.kata.dto.BeerResponse;
import com.alberti.kata.entity.Beer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BeerMapper {

    public BeerResponse toResponse(Beer beer) {
        return new BeerResponse(
                beer.getId(),
                beer.getBreweryId(),
                beer.getName(),
                beer.getCatId(),
                beer.getStyleId(),
                beer.getAbv(),
                beer.getIbu(),
                beer.getSrm(),
                beer.getUpc(),
                beer.getFilepath(),
                beer.getDescript(),
                beer.getAddUser(),
                beer.getLastMod()
        );
    }

    public Beer toEntity(BeerRequest request) {
        Beer beer = new Beer();
        beer.setBreweryId(request.breweryId());
        beer.setName(request.name());
        beer.setCatId(request.catId());
        beer.setStyleId(request.styleId());
        beer.setAbv(request.abv());
        beer.setIbu(request.ibu());
        beer.setSrm(request.srm());
        beer.setUpc(request.upc());
        beer.setFilepath(request.filepath());
        beer.setDescript(request.descript());
        beer.setLastMod(LocalDateTime.now());
        return beer;
    }

    public void updateEntity(Beer beer, BeerRequest request) {
        beer.setBreweryId(request.breweryId());
        beer.setName(request.name());
        beer.setCatId(request.catId());
        beer.setStyleId(request.styleId());
        beer.setAbv(request.abv());
        beer.setIbu(request.ibu());
        beer.setSrm(request.srm());
        beer.setUpc(request.upc());
        beer.setFilepath(request.filepath());
        beer.setDescript(request.descript());
        beer.setLastMod(LocalDateTime.now());
    }
}
