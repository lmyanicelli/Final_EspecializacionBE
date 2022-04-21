package com.serieservice.controller;

import com.serieservice.model.Genre;
import com.serieservice.model.Serie;
import com.serieservice.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
    private SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(serieService.findAllByGenre(Genre.valueOf(genre)));
    }

    @PostMapping
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie) {
        return ResponseEntity.ok().body(serieService.save(serie));
    }
}
