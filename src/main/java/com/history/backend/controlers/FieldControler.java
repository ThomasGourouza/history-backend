package com.history.backend.controlers;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.history.backend.services.FieldService;

@RestController
@CrossOrigin
@RequestMapping("/field")
public class FieldControler {
    private static final String NOT_FOUND = "Field doesn't exist";

    @Autowired
    private FieldService fieldService;

    @GetMapping("/")
    ResponseEntity<List<String>> getAllFields() {
        return new ResponseEntity<>(fieldService.getAllFields(), HttpStatus.OK);
    }

    // @GetMapping("/{id}")
    // ResponseEntity<Field> getField(@PathVariable String id) {
    //     Field field = fieldService.getField(id);
    //     if (field == null) {
    //         return new ResponseEntity<>(null, fieldService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity<>(field, HttpStatus.OK);
    // }
    
    @PostMapping("/one")
    ResponseEntity<String> createField(@RequestParam(required = true) String field) {
        return new ResponseEntity<>(fieldService.createField(field), HttpStatus.CREATED);
    }
    
    @PostMapping("/many")
    ResponseEntity<List<String>> createFields(@RequestParam(required = true) List<String> fields) {
        return new ResponseEntity<>(fieldService.createFields(fields), HttpStatus.CREATED);
    }

    // @DeleteMapping("/{id}")
    // ResponseEntity<Field> removeField(@PathVariable String id) {
    //     Field fieldAlreadySaved = fieldService.getField(id);
    //     if (fieldAlreadySaved == null) {
    //         return new ResponseEntity<>(null, fieldService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     fieldService.removeField(id);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

}
