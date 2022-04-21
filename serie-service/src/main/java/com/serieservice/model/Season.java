package com.serieservice.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data @Builder
@Document(collection = "seasons")
public class Season {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private Long seasonNumber;
    @DBRef
    private List<Chapter> chapters;

}
