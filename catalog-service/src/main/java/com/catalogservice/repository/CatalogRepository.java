package com.catalogservice.repository;

import com.catalogservice.model.Catalog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, ObjectId> {
    Catalog findByGenre(String genre);
}
