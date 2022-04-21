package com.catalogservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonDTO {
    private ObjectId id;
    private Long seasonNumber;
    private List<ChapterDTO> chapterDTOS;

}
