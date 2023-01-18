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

import com.history.backend.models.database.TodayLocationDetail;
import com.history.backend.services.TodayLocationDetailService;

@RestController
@CrossOrigin
@RequestMapping("/today_location_detail")
public class TodayLocationDetailControler {
    private static final String NOT_FOUND = "TodayLocationDetail doesn't exist";

    @Autowired
    private TodayLocationDetailService todayLocationDetailService;

    @GetMapping("/")
    ResponseEntity<List<TodayLocationDetail>> getAllTodayLocationDetails() {
        return new ResponseEntity<>(todayLocationDetailService.getAllTodayLocationDetails(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<TodayLocationDetail> getTodayLocationDetail(@PathVariable String id) {
        TodayLocationDetail todayLocationDetail = todayLocationDetailService.getTodayLocationDetail(id);
        if (todayLocationDetail == null) {
            return new ResponseEntity<>(null, todayLocationDetailService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todayLocationDetail, HttpStatus.OK);
    }
    
    @PostMapping("/")
    ResponseEntity<TodayLocationDetail> createTodayLocationDetail(@RequestBody TodayLocationDetail todayLocationDetail) {
        return new ResponseEntity<>(todayLocationDetailService.createTodayLocationDetail(todayLocationDetail), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<TodayLocationDetail> removeTodayLocationDetail(@PathVariable String id) {
        TodayLocationDetail todayLocationDetailAlreadySaved = todayLocationDetailService.getTodayLocationDetail(id);
        if (todayLocationDetailAlreadySaved == null) {
            return new ResponseEntity<>(null, todayLocationDetailService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        todayLocationDetailService.removeTodayLocationDetail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
