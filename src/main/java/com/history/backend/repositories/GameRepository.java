package com.history.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.history.backend.models.database.Game;

public interface GameRepository extends MongoRepository<Game, String> {

    List<Game> findByNameContainingAllIgnoreCase(String name);
    
    List<Game> findByNameAndIdNot(String name, String id);

    Optional<Game> findFirstByName(String name);
    
}
