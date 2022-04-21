package com.serieservice.service;

import com.serieservice.model.Chapter;
import org.bson.types.ObjectId;

public interface ChapterService {
    Chapter save(Chapter chapter);
    Chapter findById(ObjectId id);
}
