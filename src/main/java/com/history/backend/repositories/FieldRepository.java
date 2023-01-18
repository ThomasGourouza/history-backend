package com.history.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FieldRepository extends MongoRepository<String, String> {

}
