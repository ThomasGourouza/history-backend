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

import com.history.backend.models.database.PeriodEvent;
import com.history.backend.services.PeriodEventService;

@RestController
@CrossOrigin
@RequestMapping("/period_event")
public class PeriodEventControler {
    private static final String WRONG_JSON = "Wrong JSON";
    private static final String PLAYERS_NAME = "Both players should have a distinct name";
    private static final String NOT_FOUND = "PeriodEvent doesn't exist";
    private static final String CONFLICT_POSITION = "Impossible move";
    private static final String GAME_OVER = "The periodEvent is already over";

    @Autowired
    private PeriodEventService periodEventService;

    @GetMapping("/")
    ResponseEntity<List<PeriodEvent>> getAllPeriodEvents() {
        return new ResponseEntity<>(periodEventService.getAllPeriodEvents(), HttpStatus.OK);
    }

    // @GetMapping("/search")
    // ResponseEntity<List<PeriodEvent>> getAllPeriodEventsByName(@RequestParam String name) {
    //     return new ResponseEntity<>(periodEventService.getAllPeriodEventsByName(name), HttpStatus.OK);
    // }

    @GetMapping("/{id}")
    ResponseEntity<PeriodEvent> getPeriodEvent(@PathVariable String id) {
        PeriodEvent periodEvent = periodEventService.getPeriodEvent(id);
        if (periodEvent == null) {
            return new ResponseEntity<>(null, periodEventService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(periodEvent, HttpStatus.OK);
    }
    
    @PostMapping("/")
    ResponseEntity<PeriodEvent> createPeriodEvent(@RequestBody PeriodEvent periodEvent) {
        return new ResponseEntity<>(periodEventService.createPeriodEvent(periodEvent), HttpStatus.CREATED);
    }

    // @PutMapping("/{id}")
    // ResponseEntity<PeriodEvent> putPeriodEvent(@PathVariable String id, @RequestBody PeriodEvent periodEventPutRequest) {
    //     if (periodEventService.isWrongPeriodEventJSON(periodEventPutRequest)) {
    //         return new ResponseEntity<>(null, periodEventService.header(WRONG_JSON), HttpStatus.BAD_REQUEST);
    //     }
    //     PeriodEvent periodEvent = periodEventService.getPeriodEvent(id);
    //     if (periodEvent == null) {
    //         return new ResponseEntity<>(null, periodEventService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     periodEvent.setName(periodEventPutRequest.getName());
    //     periodEvent.setDescription(periodEventPutRequest.getDescription());
    //     periodEvent.getPlayers().forEach(player ->
    //         player.setName(player.getId() == 1 ? periodEventPutRequest.getPlayer1() : periodEventPutRequest.getPlayer2())
    //     );
    //     return new ResponseEntity<>(periodEventService.createPeriodEvent(periodEvent), HttpStatus.ACCEPTED);
    // }

    // @PatchMapping("/{id}/play")
    // ResponseEntity<PeriodEvent> setPosition(@PathVariable String id, @RequestBody PositionPostRequest positionPostRequest) {
    //     PeriodEvent periodEvent = periodEventService.getPeriodEvent(id);
    //     if (periodEvent == null) {
    //         return new ResponseEntity<>(null, periodEventService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     if (periodEventService.isWrongPositionJSON(positionPostRequest)) {
    //         return new ResponseEntity<>(null, periodEventService.header(WRONG_JSON), HttpStatus.BAD_REQUEST);
    //     }
    //     if (periodEvent.isOver()) {
    //         return new ResponseEntity<>(null, periodEventService.header(GAME_OVER), HttpStatus.METHOD_NOT_ALLOWED);
    //     }
    //     Position lastPosition = periodEventService.getLastPosition(periodEvent);
    //     if (periodEventService.isconflictPosition(lastPosition, positionPostRequest)) {
    //         return new ResponseEntity<>(null, periodEventService.header(CONFLICT_POSITION), HttpStatus.CONFLICT);
    //     }
    //     Position newPosition = periodEventService.getNewPosition(
    //             lastPosition,
    //             positionPostRequest);
    //     periodEventService.addNewPositionToPeriodEvent(periodEvent, newPosition);
    //     return new ResponseEntity<>(periodEventService.createPeriodEvent(periodEvent), HttpStatus.ACCEPTED);
    // }

    // @GetMapping("/{id}/moves")
    // ResponseEntity<List<PositionPostRequest>> getAiMoves(@PathVariable String id) {
    //     PeriodEvent periodEvent = periodEventService.getPeriodEvent(id);
    //     if (periodEvent == null) {
    //         return new ResponseEntity<>(null, periodEventService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     if (periodEvent.isOver()) {
    //         return new ResponseEntity<>(null, periodEventService.header(GAME_OVER), HttpStatus.METHOD_NOT_ALLOWED);
    //     }
    //     return new ResponseEntity<>(aiService.getAiPositions(periodEventService.getLastPosition(periodEvent)), HttpStatus.ACCEPTED);
    // }

    @DeleteMapping("/{id}")
    ResponseEntity<PeriodEvent> removePeriodEvent(@PathVariable String id) {
        PeriodEvent periodEventAlreadySaved = periodEventService.getPeriodEvent(id);
        if (periodEventAlreadySaved == null) {
            return new ResponseEntity<>(null, periodEventService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        periodEventService.removePeriodEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // @DeleteMapping("/")
    // ResponseEntity<PeriodEvent> removeAllPeriodEvent() {
    //     periodEventService.removeAllPeriodEvents();
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

}
