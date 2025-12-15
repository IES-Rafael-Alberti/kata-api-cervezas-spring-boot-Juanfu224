package com.alberti.kata.mapper;

import com.alberti.kata.dto.StyleResponse;
import com.alberti.kata.entity.Style;
import org.springframework.stereotype.Component;

@Component
public class StyleMapper {

    public StyleResponse toResponse(Style style) {
        return new StyleResponse(
            style.getId(),
            style.getCatId(),
            style.getStyleName(),
            style.getLastMod()
        );
    }
}
