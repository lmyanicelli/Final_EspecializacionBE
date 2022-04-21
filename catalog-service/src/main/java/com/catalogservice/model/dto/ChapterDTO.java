package com.catalogservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChapterDTO {
    private Long id;
    private String name;
    private Integer number;
    private String urlStream;
}
