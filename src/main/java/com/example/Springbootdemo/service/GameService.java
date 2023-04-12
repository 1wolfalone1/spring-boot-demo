package com.example.Springbootdemo.service;

import com.example.Springbootdemo.entity.Game;
import com.example.Springbootdemo.error.GameNotFoundException;

import java.util.List;

public interface GameService {
    Game saveGame(Game game);

    List<Game> getAllGame();

    Game getGameById(int gameID) throws GameNotFoundException;

    void deleteGameById(int id);

    Game updateGame(int gameId, Game game);

    Game getGameByName(String name);
    public List<Game> filterByName(String name);
}
