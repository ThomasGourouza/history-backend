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
import com.history.backend.models.post.CenturyPost;
import com.history.backend.services.PeriodEventService;

@RestController
@CrossOrigin
@RequestMapping("/period-event")
public class PeriodEventControler {
    private static final String WRONG_JSON = "Wrong JSON";
    private static final String PLAYERS_NAME = "Both players should have a distinct name";
    private static final String NOT_FOUND = "Game doesn't exist";
    private static final String CONFLICT_POSITION = "Impossible move";
    private static final String GAME_OVER = "The game is already over";

    @Autowired
    private PeriodEventService periodEventService;

    @GetMapping("/")
    ResponseEntity<List<PeriodEvent>> getAllPeriodEvents() {
        return new ResponseEntity<>(periodEventService.getAllPeriodEvents(), HttpStatus.OK);
    }

    // @GetMapping("/search")
    // ResponseEntity<List<PeriodEvent>> getAllGamesByName(@RequestParam String name) {
    //     return new ResponseEntity<>(periodEventService.getAllGamesByName(name), HttpStatus.OK);
    // }

    // @GetMapping("/{id}")
    // ResponseEntity<PeriodEvent> getGame(@PathVariable String id) {
    //     PeriodEvent game = periodEventService.getGame(id);
    //     if (game == null) {
    //         return new ResponseEntity<>(null, periodEventService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity<>(game, HttpStatus.OK);
    // }
    //
    // @PostMapping("/")
    // ResponseEntity<PeriodEvent> createGame(@RequestBody CenturyPost gamePostRequest) {
    //     if (periodEventService.isWrongGameJSON(gamePostRequest)) {
    //         return new ResponseEntity<>(null, periodEventService.header(WRONG_JSON), HttpStatus.BAD_REQUEST);
    //     }
    //     if (StringUtils.isBlank(gamePostRequest.getPlayer1()) || StringUtils.isBlank(gamePostRequest.getPlayer2())
    //             || StringUtils.equals(gamePostRequest.getPlayer1(), gamePostRequest.getPlayer2())) {
    //         return new ResponseEntity<>(null, periodEventService.header(PLAYERS_NAME), HttpStatus.METHOD_NOT_ALLOWED);
    //     }
    //     PeriodEvent game = periodEventService.initGame(gamePostRequest);
    //     return new ResponseEntity<>(periodEventService.createGame(game), HttpStatus.CREATED);
    // }

    // @PutMapping("/{id}")
    // ResponseEntity<PeriodEvent> putGame(@PathVariable String id, @RequestBody CenturyPost gamePutRequest) {
    //     if (periodEventService.isWrongGameJSON(gamePutRequest)) {
    //         return new ResponseEntity<>(null, periodEventService.header(WRONG_JSON), HttpStatus.BAD_REQUEST);
    //     }
    //     PeriodEvent game = periodEventService.getGame(id);
    //     if (game == null) {
    //         return new ResponseEntity<>(null, periodEventService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     game.setName(gamePutRequest.getName());
    //     game.setDescription(gamePutRequest.getDescription());
    //     game.getPlayers().forEach(player ->
    //         player.setName(player.getId() == 1 ? gamePutRequest.getPlayer1() : gamePutRequest.getPlayer2())
    //     );
    //     return new ResponseEntity<>(periodEventService.createGame(game), HttpStatus.ACCEPTED);
    // }

    // @PatchMapping("/{id}/play")
    // ResponseEntity<PeriodEvent> setPosition(@PathVariable String id, @RequestBody PositionPostRequest positionPostRequest) {
    //     PeriodEvent game = periodEventService.getGame(id);
    //     if (game == null) {
    //         return new ResponseEntity<>(null, periodEventService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     if (periodEventService.isWrongPositionJSON(positionPostRequest)) {
    //         return new ResponseEntity<>(null, periodEventService.header(WRONG_JSON), HttpStatus.BAD_REQUEST);
    //     }
    //     if (game.isOver()) {
    //         return new ResponseEntity<>(null, periodEventService.header(GAME_OVER), HttpStatus.METHOD_NOT_ALLOWED);
    //     }
    //     Position lastPosition = periodEventService.getLastPosition(game);
    //     if (periodEventService.isconflictPosition(lastPosition, positionPostRequest)) {
    //         return new ResponseEntity<>(null, periodEventService.header(CONFLICT_POSITION), HttpStatus.CONFLICT);
    //     }
    //     Position newPosition = periodEventService.getNewPosition(
    //             lastPosition,
    //             positionPostRequest);
    //     periodEventService.addNewPositionToGame(game, newPosition);
    //     return new ResponseEntity<>(periodEventService.createGame(game), HttpStatus.ACCEPTED);
    // }

    // @GetMapping("/{id}/moves")
    // ResponseEntity<List<PositionPostRequest>> getAiMoves(@PathVariable String id) {
    //     PeriodEvent game = periodEventService.getGame(id);
    //     if (game == null) {
    //         return new ResponseEntity<>(null, periodEventService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     if (game.isOver()) {
    //         return new ResponseEntity<>(null, periodEventService.header(GAME_OVER), HttpStatus.METHOD_NOT_ALLOWED);
    //     }
    //     return new ResponseEntity<>(aiService.getAiPositions(periodEventService.getLastPosition(game)), HttpStatus.ACCEPTED);
    // }

    // @DeleteMapping("/{id}")
    // ResponseEntity<PeriodEvent> removeGame(@PathVariable String id) {
    //     PeriodEvent gameAlreadySaved = periodEventService.getGame(id);
    //     if (gameAlreadySaved == null) {
    //         return new ResponseEntity<>(null, periodEventService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     periodEventService.removeGame(id);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    // @DeleteMapping("/")
    // ResponseEntity<PeriodEvent> removeAllGame() {
    //     periodEventService.removeAllGames();
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

}
