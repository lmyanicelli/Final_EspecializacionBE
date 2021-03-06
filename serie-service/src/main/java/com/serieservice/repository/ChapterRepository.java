package com.serieservice.repository;

import com.serieservice.model.Chapter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends MongoRepository<Chapter, ObjectId> {
}
