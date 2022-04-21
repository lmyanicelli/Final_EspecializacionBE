package com.catalogservice.controller;

import com.catalogservice.model.Catalog;
import com.catalogservice.model.Movie;
import com.catalogservice.model.Serie;
import com.catalogservice.model.dto.CatalogDTO;
import com.catalogservice.model.dto.MovieDTO;
import com.catalogservice.model.dto.SerieDTO;
import com.catalogservice.queue.MovieListener;
import com.catalogservice.queue.MovieSender;
import com.catalogservice.service.CatalogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/catalog")
public class CatalogController {
	private final MovieListener movieListener;
	private CatalogService catalogService;

	Logger logger = LoggerFactory.getLogger(CatalogController.class);

	@Autowired
	public CatalogController(MovieListener movieListener,
							 CatalogService catalogService) {
		this.movieListener = movieListener;
		this.catalogService = catalogService;
	}

	@GetMapping("/{genre}")
	ResponseEntity<CatalogDTO> getCatalogByGenre(@PathVariable String genre) {
		CatalogDTO response = catalogService.getCatalogByGenre(genre);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/movies")
	public ResponseEntity<MovieDTO> saveMovie(@RequestBody Movie movie) {
		MovieDTO movieDB = catalogService.saveMovie(movie);
		movieListener.receive(movie);
		return ResponseEntity.ok().body(movieDB);
	}

	@PostMapping("/series")
	public ResponseEntity<SerieDTO> saveSerie(@RequestBody Serie serie) {
		return ResponseEntity.ok().body(catalogService.saveSerie(serie));
	}
}
