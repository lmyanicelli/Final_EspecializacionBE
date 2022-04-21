package com.serieservice.repository;

import com.serieservice.model.Season;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends MongoRepository<Season,Long> {
}
