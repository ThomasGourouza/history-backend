package com.history.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.history.backend.models.database.Century;

public interface CenturyRepository extends MongoRepository<Century, String> {
    
}
