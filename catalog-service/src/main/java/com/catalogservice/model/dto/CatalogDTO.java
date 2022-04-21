package com.catalogservice.model.dto;

import com.catalogservice.model.Genre;
import com.catalogservice.model.Movie;
import com.catalogservice.model.Serie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data @Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogDTO {
    private Genre genre;
    private List<MovieDTO> movies;
    private List<Serie> series;
}
