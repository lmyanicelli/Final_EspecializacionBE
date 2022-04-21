package com.serieservice.service;

import com.serieservice.model.Genre;
import com.serieservice.model.Serie;


import java.util.List;

public interface SerieService {
    List<Serie> findAllByGenre(Genre genre);
    Serie save(Serie serie);
}
