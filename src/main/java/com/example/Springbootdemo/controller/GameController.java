package com.example.Springbootdemo.controller;

import com.example.Springbootdemo.entity.Game;
import com.example.Springbootdemo.service.GameService;
import com.example.Springbootdemo.error.GameNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;


    private final Logger LOGGER = LoggerFactory.getLogger(GameController.class);
    @PostMapping("/save-game")
    public Game saveGame(@Valid @RequestBody Game game){
        System.out.println(game  + "asdasdasdasdasdadasdasdadadasdasd");
        return gameService.saveGame(game);

    }

    @GetMapping("/games")
    public List<Game> getAll(){
        return gameService.getAllGame();
    }

    @GetMapping("/games/{id}")
    public Game fetchGameById(@PathVariable("id") int gameID) throws GameNotFoundException {
        return gameService.getGameById(gameID);
    }

    @DeleteMapping("/games/{id}")
    public String deleteGameById(@PathVariable("id") int id){
        gameService.deleteGameById(id);
        LOGGER.info("testtttttttttttttttttttttttt" + id + " dedleletetet");
        return "Game delete successfully";
    }

    @PutMapping("/games/{id}")
    public Game updateGame(@PathVariable("id") int gameId, @RequestBody Game game){
        return gameService.updateGame(gameId, game);
    }
    @GetMapping("/games/name/{name}")
    public Game fetchGameByName(@PathVariable("name") String name){
        return gameService.getGameByName(name);
    }

    @GetMapping("/games/name/list/{name}")
    public List<Game> filterByName(@PathVariable("name") String name){
        return gameService.filterByName(name);
    }
}
