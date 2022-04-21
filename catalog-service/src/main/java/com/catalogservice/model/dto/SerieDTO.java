package com.catalogservice.model.dto;

import com.catalogservice.model.Genre;
import com.catalogservice.model.Season;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SerieDTO {
    private ObjectId id;
    private String name;
    private Genre genre;
    private List<Season> season;
}
