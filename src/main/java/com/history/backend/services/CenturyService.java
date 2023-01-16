package com.history.backend.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.history.backend.models.database.Century;
import com.history.backend.models.database.Century;
import com.history.backend.models.post.CenturyPost;
import com.history.backend.repositories.CenturyRepository;

@Service
public class CenturyService {
    
    @Autowired
    private CenturyRepository centuryRepository;
    
    private static final String ERROR_MESSAGE = "errorMessage";

    public List<Century> getAllCenturies() {
        return centuryRepository.findAll();
    }

    // public Century getGame(String id) {
    //     return centuryRepository.findById(id).orElse(null);
    // }

    // public List<Century> getAllGamesByName(String name) {
    //     if (StringUtils.isBlank(name)) {
    //         return centuryRepository.findAll();
    //     }
    //     return centuryRepository.findByNameContainingAllIgnoreCase(name);
    // }

    // public List<Century> getAllGamesByNameExceptId(String name, String id) {
    //     return centuryRepository.findByNameAndIdNot(name, id);
    // }

    // public Century getGameByName(String name) {
    //     return centuryRepository.findFirstByName(name).orElse(null);
    // }

    public Century createCentury(CenturyPost centuryPost) {
        Century century = new Century();
        century.setNumber(centuryPost.getNumber());
        century.setRoman(centuryPost.getRoman());
        century.setBegin(1900);
        century.setEnd(2000);
        return centuryRepository.save(century);
    }

    // public void removeGame(String id) {
    //     centuryRepository.deleteById(id);
    // }

    // public void removeAllGames() {
    //     centuryRepository.deleteAll();
    // }

    // public HttpHeaders header(String message) {
    //     HttpHeaders responseHeaders = new HttpHeaders();
    //     responseHeaders.add(ERROR_MESSAGE, message);
    //     return responseHeaders;
    // }
    
}
