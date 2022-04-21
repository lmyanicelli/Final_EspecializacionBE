package com.catalogservice.client;

import com.catalogservice.model.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "serie-service")
public interface SerieClient {
    @GetMapping("/series/{genre}")
    List<Serie> getSeriesByGenre(@PathVariable String genre);

    @PostMapping("/series")
    Serie saveSerie(@RequestBody Serie serie);
}
