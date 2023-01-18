package com.history.backend.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.history.backend.models.database.Personality;
import com.history.backend.services.PersonalityService;

@RestController
@CrossOrigin
@RequestMapping("/personality")
public class PersonalityControler {
    private static final String NOT_FOUND = "Personality doesn't exist";

    @Autowired
    private PersonalityService personalityService;

    @GetMapping("/")
    ResponseEntity<List<Personality>> getAllPersonalitys() {
        return new ResponseEntity<>(personalityService.getAllPersonalitys(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Personality> getPersonality(@PathVariable String id) {
        Personality personality = personalityService.getPersonality(id);
        if (personality == null) {
            return new ResponseEntity<>(null, personalityService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personality, HttpStatus.OK);
    }
    
    @PostMapping("/")
    ResponseEntity<Personality> createPersonality(@RequestBody Personality personality) {
        return new ResponseEntity<>(personalityService.createPersonality(personality), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Personality> removePersonality(@PathVariable String id) {
        Personality personalityAlreadySaved = personalityService.getPersonality(id);
        if (personalityAlreadySaved == null) {
            return new ResponseEntity<>(null, personalityService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        personalityService.removePersonality(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
