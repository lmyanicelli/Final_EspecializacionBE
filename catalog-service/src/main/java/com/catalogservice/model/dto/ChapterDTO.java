package com.catalogservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChapterDTO {
    private ObjectId id;
    private String name;
    private Integer number;
    private String urlStream;
}
