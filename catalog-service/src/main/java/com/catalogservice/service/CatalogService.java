package com.catalogservice.service;

import com.catalogservice.model.Catalog;
import com.catalogservice.model.Movie;
import com.catalogservice.model.Serie;
import com.catalogservice.model.dto.CatalogDTO;
import com.catalogservice.model.dto.MovieDTO;
import com.catalogservice.model.dto.SerieDTO;

public interface CatalogService {
    MovieDTO saveMovie(Movie movie);
    Serie saveSerie(Serie serie);
    CatalogDTO getCatalogByGenre(String genre);
    CatalogDTO persistMovie(Movie movie);
    Catalog persistSerie(Serie serie);
}
