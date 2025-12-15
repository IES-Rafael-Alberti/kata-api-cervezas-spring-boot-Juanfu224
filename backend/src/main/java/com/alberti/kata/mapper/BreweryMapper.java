package com.alberti.kata.mapper;

import com.alberti.kata.dto.BreweryResponse;
import com.alberti.kata.entity.Brewery;
import org.springframework.stereotype.Component;

@Component
public class BreweryMapper {

    public BreweryResponse toResponse(Brewery brewery) {
        return new BreweryResponse(
            brewery.getId(),
            brewery.getName(),
            brewery.getAddress1(),
            brewery.getAddress2(),
            brewery.getCity(),
            brewery.getState(),
            brewery.getCode(),
            brewery.getCountry(),
            brewery.getPhone(),
            brewery.getWebsite(),
            brewery.getFilepath(),
            brewery.getDescript(),
            brewery.getAddUser(),
            brewery.getLastMod()
        );
    }
}
