package com.catalogservice.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "catalogs")
public class Catalog {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private Genre genre;
    private List<Movie> movies;
    private List<Serie> series;
}
