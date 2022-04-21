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
	}

	@Override
	public Serie saveSerie(Serie serie) {
		Serie serieSaved = serieClient.saveSerie(serie);
		return serieSaved;
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

	@Override
	public Catalog persistSerie(Serie serie) {
		logger.info("persistSerie de catalogService");
		Catalog catalog = repository.findByGenre(String.valueOf(serie.getGenre()));
		if(catalog==null){
			logger.info("catalog null");
			catalog = new Catalog();
			catalog.setGenre(serie.getGenre());
			List<Serie> series = new ArrayList<>();
			series.add(serie);
			logger.info("series: ", series);
			catalog.setSeries(series);
		}else{
			logger.info("catalog exist");
			List<Serie> listSeries = catalog.getSeries();
			if(listSeries==null){
				listSeries = new ArrayList<>();
			}
			listSeries.add(serie);

			logger.info("listSeries: " + listSeries);
			catalog.setSeries(listSeries);
		}

		logger.info("catalog fuera del if: " + catalog.toString());

		return repository.save(catalog);
	}
}
