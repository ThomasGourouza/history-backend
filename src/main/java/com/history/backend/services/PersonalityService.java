package com.history.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.history.backend.models.database.Personality;
import com.history.backend.repositories.PersonalityRepository;

@Service
public class PersonalityService {
    
    @Autowired
    private PersonalityRepository personalityRepository;
    
    private static final String ERROR_MESSAGE = "errorMessage";

    public List<Personality> getAllPersonalitys() {
        return personalityRepository.findAll();
    }

    public Personality createPersonality(Personality personality) {
        return personalityRepository.save(personality);
    }

    public Personality getPersonality(String id) {
        return personalityRepository.findById(id).orElse(null);
    }

    public void removePersonality(String id) {
        personalityRepository.deleteById(id);
    }

    public HttpHeaders header(String message) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(ERROR_MESSAGE, message);
        return responseHeaders;
    }
    
}
