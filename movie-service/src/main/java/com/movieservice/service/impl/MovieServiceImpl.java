package com.movieservice.service.impl;

import com.movieservice.model.Movie;
import com.movieservice.repository.MovieRepository;
import com.movieservice.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getListByGenre(String genre) {
        logger.info(genre);
        List<Movie> list = movieRepository.findAllByGenre(genre);
        logger.info("listado: " + list);
        return list;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

}
