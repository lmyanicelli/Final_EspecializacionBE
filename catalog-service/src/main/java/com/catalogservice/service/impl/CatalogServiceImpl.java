package com.catalogservice.service.impl;

import com.catalogservice.model.*;
import com.catalogservice.model.dto.*;
import com.catalogservice.model.Catalog;
import com.catalogservice.client.MovieClient;
import com.catalogservice.client.SerieClient;
import com.catalogservice.repository.CatalogRepository;
import com.catalogservice.service.CatalogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CatalogServiceImpl implements CatalogService {
	private MovieClient movieClient;
	private SerieClient serieClient;
	private ModelMapper modelMapper;
	private ObjectMapper mapper;
	private CatalogRepository repository;

	Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);

	@Autowired
	public CatalogServiceImpl(MovieClient movieClient,
							  SerieClient serieClient,
							  CatalogRepository catalogRepository,
							  ModelMapper modelMapper,
							  ObjectMapper mapper) {
		this.movieClient = movieClient;
		this.serieClient = serieClient;
		this.repository = catalogRepository;
		this.modelMapper = modelMapper;
		this.mapper = mapper;
	}

	@Override
	public MovieDTO saveMovie(Movie movie) {
		Movie movieSaved = movieClient.saveMovie(movie);
		logger.info("saveMovie de catalogService");
		return mapper.convertValue(movieSaved, MovieDTO.class);
		//luego enviar el mensaje con rabbitMQ
	}

	@Override
	public SerieDTO saveSerie(Serie serie) {
		Serie serieSaved = serieClient.saveSerie(serie);
		return mapper.convertValue(serieSaved, SerieDTO.class);
		//luego enviar el mensaje con rabbitMQ
	}

	@Override
	public CatalogDTO getCatalogByGenre(String genre) {
		List<Movie> moviesByGenre = movieClient.getMovieByGenre(genre);
		List<Serie> seriesByGenre = serieClient.getSeriesByGenre(genre);
		/*Catalog catalog = Catalog.builder()
				.genre(Genre.valueOf(genre))
				.movies(moviesByGenre)
				.series(seriesByGenre)
				.build();*/
		return CatalogDTO.builder()
				.genre(Genre.valueOf(genre))
				.movies(modelMapper.map(moviesByGenre,
						new TypeToken<List<MovieDTO>>() {}.getType()))
				.series(seriesByGenre)
				.build();
	}

	@Override
	public CatalogDTO persistMovie(Movie movie) {
		Catalog catalog = repository.findByGenre(String.valueOf(movie.getGenre()));
		if(catalog==null){
			catalog = new Catalog();
			catalog.setGenre(movie.getGenre());
			List<Movie> movies = new ArrayList<>();
			movies.add(movie);
			catalog.setMovies(movies);
		}else{
			List<Movie> listMovies = catalog.getMovies();
			listMovies.add(movie);
			catalog.setMovies(listMovies);
		}

		return mapper.convertValue(repository.save(catalog), CatalogDTO.class);
	}
}
