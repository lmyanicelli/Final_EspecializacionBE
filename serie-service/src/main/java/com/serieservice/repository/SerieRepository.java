package com.serieservice.repository;

import com.serieservice.model.Serie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends MongoRepository<Serie, ObjectId> {
    List<Serie> findAllByGenre(String genre);
}
