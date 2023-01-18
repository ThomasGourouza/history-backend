package com.history.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.history.backend.repositories.FieldRepository;

@Service
public class FieldService {

    @Autowired
    private FieldRepository fieldRepository;

    private static final String ERROR_MESSAGE = "errorMessage";

    public List<String> getAllFields() {
        return fieldRepository.findAll();
    }

    // public String getField(String id) {
    //     return fieldRepository.findById(id).orElse(null);
    // }

    public String createField(String field) {
        return fieldRepository.save(field);
    }

    public List<String> createFields(List<String> fields) {
        return fieldRepository.saveAll(fields);
    }

    // public void removeField(String id) {
    //     fieldRepository.deleteById(id);
    // }

    // public void removeAllFields() {
    // fieldRepository.deleteAll();
    // }

    public HttpHeaders header(String message) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(ERROR_MESSAGE, message);
        return responseHeaders;
    }
}
