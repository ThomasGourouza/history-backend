package com.history.backend.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.history.backend.models.database.PeriodEvent;
import com.history.backend.repositories.PeriodEventRepository;

@Service
public class PeriodEventService {
    
    @Autowired
    private PeriodEventRepository periodEventRepository;
    
    private static final String ERROR_MESSAGE = "errorMessage";

    public List<PeriodEvent> getAllPeriodEvents() {
        return periodEventRepository.findAll();
    }

    // public PeriodEvent getGame(String id) {
    //     return periodEventRepository.findById(id).orElse(null);
    // }

    // public List<PeriodEvent> getAllGamesByName(String name) {
    //     if (StringUtils.isBlank(name)) {
    //         return periodEventRepository.findAll();
    //     }
    //     return periodEventRepository.findByNameContainingAllIgnoreCase(name);
    // }

    // public List<PeriodEvent> getAllGamesByNameExceptId(String name, String id) {
    //     return periodEventRepository.findByNameAndIdNot(name, id);
    // }

    // public PeriodEvent getGameByName(String name) {
    //     return periodEventRepository.findFirstByName(name).orElse(null);
    // }

    // public PeriodEvent createGame(PeriodEvent game) {
    //     return periodEventRepository.save(game);
    // }

    // public void removeGame(String id) {
    //     periodEventRepository.deleteById(id);
    // }

    // public void removeAllGames() {
    //     periodEventRepository.deleteAll();
    // }

    // public HttpHeaders header(String message) {
    //     HttpHeaders responseHeaders = new HttpHeaders();
    //     responseHeaders.add(ERROR_MESSAGE, message);
    //     return responseHeaders;
    // }
    
}
