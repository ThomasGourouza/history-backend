package com.history.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.history.backend.models.database.TodayLocationDetail;
import com.history.backend.repositories.TodayLocationDetailRepository;

@Service
public class TodayLocationDetailService {
    
    @Autowired
    private TodayLocationDetailRepository todayLocationDetailRepository;
    
    private static final String ERROR_MESSAGE = "errorMessage";

    public List<TodayLocationDetail> getAllTodayLocationDetails() {
        return todayLocationDetailRepository.findAll();
    }

    public TodayLocationDetail createTodayLocationDetail(TodayLocationDetail todayLocationDetail) {
        return todayLocationDetailRepository.save(todayLocationDetail);
    }

    public TodayLocationDetail getTodayLocationDetail(String id) {
        return todayLocationDetailRepository.findById(id).orElse(null);
    }

    public void removeTodayLocationDetail(String id) {
        todayLocationDetailRepository.deleteById(id);
    }

    public HttpHeaders header(String message) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(ERROR_MESSAGE, message);
        return responseHeaders;
    }
    
}
