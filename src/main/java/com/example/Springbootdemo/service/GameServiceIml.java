package com.example.Springbootdemo.service;

import com.example.Springbootdemo.entity.Game;
import com.example.Springbootdemo.repository.GameRepo;
import com.example.Springbootdemo.error.GameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceIml implements GameService{

    @Autowired
    private GameRepo gameRepo;
    @Override
    public Game saveGame(Game game) {
        return gameRepo.save(game);
    }

    @Override
    public List<Game> getAllGame() {
        return gameRepo.findAll();
    }

    @Override
    public Game getGameById(int gameID) throws GameNotFoundException {
        Optional<Game> gameOptional= gameRepo.findById(gameID);
        if(gameOptional.isPresent()){
            return gameOptional.get();
        } else {
            throw new GameNotFoundException("Game is not Available");
        }

    }

    @Override
    public void deleteGameById(int id) {
        gameRepo.deleteById(id);
    }

    @Override
    public Game updateGame(int gameId, Game game) {
        Game gameDb = gameRepo.findById(gameId).get();

        if(gameDb != null){
            game.setId(gameId);
            return gameRepo.save(game);
        }
        return null;
    }

    @Override
    public Game getGameByName(String name) {
        return gameRepo.findByGameNameIgnoreCase(name);
    }

    public List<Game> filterByName(String name) {
        return gameRepo.filterByName(name);
    }


}
