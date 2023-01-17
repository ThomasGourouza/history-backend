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

import com.history.backend.models.database.Century;
import com.history.backend.models.database.Century;
import com.history.backend.models.post.CenturyPost;
import com.history.backend.services.CenturyService;

@RestController
@CrossOrigin
@RequestMapping("/century")
public class CenturyControler {
    private static final String NOT_FOUND = "Century doesn't exist";

    @Autowired
    private CenturyService centuryService;

    @GetMapping("/")
    ResponseEntity<List<Century>> getAllCenturies() {
        return new ResponseEntity<>(centuryService.getAllCenturies(), HttpStatus.OK);
    }

    @GetMapping("/search")
    ResponseEntity<Century> getCenturyByNumber(@RequestParam(required = true) String number) {
        Century century = centuryService.getCenturyByNumber(number);
        if (century == null) {
            return new ResponseEntity<>(null, centuryService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(century, HttpStatus.OK);
    }

    @GetMapping("/search_between")
    ResponseEntity<List<Century>> getCenturyBetween(@RequestParam(required = true) String begin, @RequestParam(required = true) String end) {
        return new ResponseEntity<>(centuryService.getCenturyBetween(begin, end), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Century> getCentury(@PathVariable String id) {
        Century century = centuryService.getCentury(id);
        if (century == null) {
            return new ResponseEntity<>(null, centuryService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(century, HttpStatus.OK);
    }
    
    @PostMapping("/")
    ResponseEntity<Century> createCentury(@RequestBody CenturyPost centuryPost) {
        return new ResponseEntity<>(centuryService.createCentury(centuryPost), HttpStatus.CREATED);
    }
    
    @PostMapping("/many")
    ResponseEntity<List<Century>> createCenturies(@RequestBody List<CenturyPost> centuryPosts) {
        return new ResponseEntity<>(centuryService.createCenturies(centuryPosts), HttpStatus.CREATED);
    }

    // @PutMapping("/{id}")
    // ResponseEntity<Century> putGame(@PathVariable String id, @RequestBody CenturyPost gamePutRequest) {
    //     if (centuryService.isWrongGameJSON(gamePutRequest)) {
    //         return new ResponseEntity<>(null, centuryService.header(WRONG_JSON), HttpStatus.BAD_REQUEST);
    //     }
    //     Century game = centuryService.getGame(id);
    //     if (game == null) {
    //         return new ResponseEntity<>(null, centuryService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     game.setName(gamePutRequest.getName());
    //     game.setDescription(gamePutRequest.getDescription());
    //     game.getPlayers().forEach(player ->
    //         player.setName(player.getId() == 1 ? gamePutRequest.getPlayer1() : gamePutRequest.getPlayer2())
    //     );
    //     return new ResponseEntity<>(centuryService.createGame(game), HttpStatus.ACCEPTED);
    // }

    // @PatchMapping("/{id}/play")
    // ResponseEntity<Century> setPosition(@PathVariable String id, @RequestBody PositionPostRequest positionPostRequest) {
    //     Century game = centuryService.getGame(id);
    //     if (game == null) {
    //         return new ResponseEntity<>(null, centuryService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     if (centuryService.isWrongPositionJSON(positionPostRequest)) {
    //         return new ResponseEntity<>(null, centuryService.header(WRONG_JSON), HttpStatus.BAD_REQUEST);
    //     }
    //     if (game.isOver()) {
    //         return new ResponseEntity<>(null, centuryService.header(GAME_OVER), HttpStatus.METHOD_NOT_ALLOWED);
    //     }
    //     Position lastPosition = centuryService.getLastPosition(game);
    //     if (centuryService.isconflictPosition(lastPosition, positionPostRequest)) {
    //         return new ResponseEntity<>(null, centuryService.header(CONFLICT_POSITION), HttpStatus.CONFLICT);
    //     }
    //     Position newPosition = centuryService.getNewPosition(
    //             lastPosition,
    //             positionPostRequest);
    //     centuryService.addNewPositionToGame(game, newPosition);
    //     return new ResponseEntity<>(centuryService.createGame(game), HttpStatus.ACCEPTED);
    // }

    // @GetMapping("/{id}/moves")
    // ResponseEntity<List<PositionPostRequest>> getAiMoves(@PathVariable String id) {
    //     Century game = centuryService.getGame(id);
    //     if (game == null) {
    //         return new ResponseEntity<>(null, centuryService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
    //     }
    //     if (game.isOver()) {
    //         return new ResponseEntity<>(null, centuryService.header(GAME_OVER), HttpStatus.METHOD_NOT_ALLOWED);
    //     }
    //     return new ResponseEntity<>(aiService.getAiPositions(centuryService.getLastPosition(game)), HttpStatus.ACCEPTED);
    // }

    @DeleteMapping("/{id}")
    ResponseEntity<Century> removeCentury(@PathVariable String id) {
        Century centuryAlreadySaved = centuryService.getCentury(id);
        if (centuryAlreadySaved == null) {
            return new ResponseEntity<>(null, centuryService.header(NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        centuryService.removeCentury(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // @DeleteMapping("/")
    // ResponseEntity<Century> removeAllGame() {
    //     centuryService.removeAllGames();
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

}
