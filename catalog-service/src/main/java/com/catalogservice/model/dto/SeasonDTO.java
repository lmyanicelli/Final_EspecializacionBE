package com.catalogservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonDTO {
    private Long id;
    private Long seasonNumber;
    private List<ChapterDTO> chapterDTOS;

}
