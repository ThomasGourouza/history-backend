package com.history.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.history.backend.models.database.PeriodEvent;

public interface PeriodEventRepository extends MongoRepository<PeriodEvent, String> {

    List<PeriodEvent> findByNameContainingAllIgnoreCase(String name);
    
    List<PeriodEvent> findByNameAndIdNot(String name, String id);

    Optional<PeriodEvent> findFirstByName(String name);
    
}
