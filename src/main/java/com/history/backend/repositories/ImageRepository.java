package com.history.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.history.backend.models.database.Image;

public interface ImageRepository extends MongoRepository<Image, String> {
    
}
