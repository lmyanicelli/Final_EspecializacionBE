package com.catalogservice.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
@Document(collection = "catalogs")
public class Catalog {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private Genre genre;
    private List<Movie> movies;
    private List<Serie> series;
}
