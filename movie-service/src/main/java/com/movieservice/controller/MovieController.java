package com.movieservice.controller;

import com.movieservice.model.Movie;
import com.movieservice.queue.MovieSender;
import com.movieservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;
    private final MovieSender movieSender;

    Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    public MovieController(MovieService movieService, MovieSender movieSender) {
        this.movieService = movieService;
        this.movieSender = movieSender;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(movieService.getListByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        logger.info("saveMovie de MovieController");
        Movie movieDB = movieService.save(movie);
        movieSender.send(movieDB);
        return ResponseEntity.ok().body(movieDB);
    }
}
