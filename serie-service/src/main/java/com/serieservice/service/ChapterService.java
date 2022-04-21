package com.serieservice.service;

import com.serieservice.model.Chapter;

public interface ChapterService {
    Chapter save(Chapter chapter);
    Chapter findById(Long id);
}
