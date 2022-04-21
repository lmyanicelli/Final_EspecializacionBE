package com.catalogservice.client;

import com.catalogservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "movie-service")
public interface MovieClient {
    @GetMapping("/movies/{genre}")
    List<Movie> getMovieByGenre(@PathVariable String genre);

    @PostMapping("/movies")
    Movie saveMovie(@RequestBody Movie movie);
}
