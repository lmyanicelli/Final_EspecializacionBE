package com.catalogservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@Document(collection = "movies")
public class Movie {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private Genre genre;
    private String urlStream;
}
