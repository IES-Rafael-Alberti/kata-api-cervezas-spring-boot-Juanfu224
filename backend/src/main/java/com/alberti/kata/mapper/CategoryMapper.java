package com.alberti.kata.mapper;

import com.alberti.kata.dto.CategoryResponse;
import com.alberti.kata.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
            category.getId(),
            category.getCatName(),
            category.getLastMod()
        );
    }
}
