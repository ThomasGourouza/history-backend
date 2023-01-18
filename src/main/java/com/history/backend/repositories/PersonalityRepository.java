package com.history.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.history.backend.models.database.Personality;

public interface PersonalityRepository extends MongoRepository<Personality, String> {
    
}
