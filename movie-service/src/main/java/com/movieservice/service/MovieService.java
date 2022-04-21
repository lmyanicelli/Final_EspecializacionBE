package com.movieservice.service;

import com.movieservice.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getListByGenre(String genre);
    Movie save(Movie movie);
}
