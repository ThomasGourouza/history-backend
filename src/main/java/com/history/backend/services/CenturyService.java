package com.history.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public Century getCentury(String id) {
        return centuryRepository.findById(id).orElse(null);
    }

    public Century getCenturyByNumber(String number) {
        return centuryRepository.findByNumber(Integer.parseInt(number));
    }

    public List<Century> getCenturyBetween(String begin, String end) {
        List<Century> allCenturies = getAllCenturies();
        List<Century> centuries = new ArrayList<>();
        Optional<Century> centuryBeginOpt = allCenturies.stream().filter(century ->
            century.getBegin() < Integer.parseInt(begin) && century.getEnd() > Integer.parseInt(begin)
        ).findFirst();
        Optional<Century> centuryEndOpt = allCenturies.stream().filter(century ->
            century.getBegin() < Integer.parseInt(end) && century.getEnd() > Integer.parseInt(end)
        ).findFirst();
        if (centuryBeginOpt.isPresent() && centuryEndOpt.isPresent()) {
            centuries = allCenturies.stream().filter(century ->
                century.getNumber() >= centuryBeginOpt.get().getNumber() && century.getNumber() <= centuryEndOpt.get().getNumber()
            ).collect(Collectors.toList());
        }
        return centuries;
    }

    // public List<Century> getAllCenturiesByName(String name) {
    // if (StringUtils.isBlank(name)) {
    // return centuryRepository.findAll();
    // }
    // return centuryRepository.findByNameContainingAllIgnoreCase(name);
    // }

    // public List<Century> getAllCenturiesByNameExceptId(String name, String id) {
    // return centuryRepository.findByNameAndIdNot(name, id);
    // }

    // public Century getCenturyByName(String name) {
    // return centuryRepository.findFirstByName(name).orElse(null);
    // }

    public Century mapToCentury(CenturyPost centuryPost) {
        Century century = new Century();
        century.setNumber(centuryPost.getNumber());
        century.setRoman(centuryPost.getRoman());
        century.setBegin(
            (centuryPost.getNumber() > 0 ? centuryPost.getNumber() - 1 : centuryPost.getNumber()) * 100
        );
        century.setEnd(century.getBegin() + 99);
        return century;
    }

    public Century createCentury(CenturyPost centuryPost) {
        return centuryRepository.save(mapToCentury(centuryPost));
    }

    public List<Century> createCenturies(List<CenturyPost> centuryPosts) {
        List<Century> centuries = centuryPosts.stream().map(centuryPost ->
            mapToCentury(centuryPost)
        ).collect(Collectors.toList());
        return centuryRepository.saveAll(centuries);
    }

    public void removeCentury(String id) {
        centuryRepository.deleteById(id);
    }

    // public void removeAllCenturies() {
    // centuryRepository.deleteAll();
    // }

    public HttpHeaders header(String message) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(ERROR_MESSAGE, message);
        return responseHeaders;
    }

}
