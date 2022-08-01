package com.moviestore.cjv.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackdropRepository extends MongoRepository<Backdrop, String> {
}
