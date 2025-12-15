package com.alberti.kata.repository;

import com.alberti.kata.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Integer> {
}
