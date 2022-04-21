package com.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genre {
    ACTION("ACTION"),
    ADVENTURE("ADVENTURE"),
    HUMOR("HUMOR"),
    COMEDY("COMEDY"),
    ROMANCE("ROMANCE"),
    TERROR("TERROR");

    private String name;
}
