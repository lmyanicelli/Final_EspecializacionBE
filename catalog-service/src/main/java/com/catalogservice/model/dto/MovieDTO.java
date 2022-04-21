package com.catalogservice.model.dto;

import com.catalogservice.model.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {
    private Long id;
    private String name;
    private Genre genre;
    private String urlStream;
}
