package com.history.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.history.backend.models.database.TodayLocationDetail;

public interface TodayLocationDetailRepository extends MongoRepository<TodayLocationDetail, String> {
    
}
