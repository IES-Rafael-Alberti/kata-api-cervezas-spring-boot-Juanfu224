package com.alberti.kata;

import com.alberti.kata.controller.BeerController;
import com.alberti.kata.controller.BreweryController;
import com.alberti.kata.controller.CategoryController;
import com.alberti.kata.controller.StyleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class KataApplicationTests {

	@Autowired
	private BeerController beerController;

	@Autowired
	private BreweryController breweryController;

	@Autowired
	private CategoryController categoryController;

	@Autowired
	private StyleController styleController;

	@Test
	void contextLoads() {
		assertThat(beerController).isNotNull();
		assertThat(breweryController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(styleController).isNotNull();
	}

	@Test
	void testBeerEndpointsExist() {
		assertThat(beerController.getAllBeers(PageRequest.of(0, 10), null)).isNotNull();
	}

	@Test
	void testBreweryEndpointsExist() {
		assertThat(breweryController.getAllBreweries()).isNotNull();
	}

	@Test
	void testCategoryEndpointsExist() {
		assertThat(categoryController.getAllCategories()).isNotNull();
	}

	@Test
	void testStyleEndpointsExist() {
		assertThat(styleController.getAllStyles()).isNotNull();
	}
}
