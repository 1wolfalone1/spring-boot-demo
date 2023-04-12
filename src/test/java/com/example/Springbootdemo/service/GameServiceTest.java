package com.example.Springbootdemo.service;


import com.example.Springbootdemo.entity.Game;
import com.example.Springbootdemo.repository.GameRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameServiceTest {
    @Autowired
    private GameService gameService;

    @MockBean
    private GameRepo gameRepo;
    @BeforeEach
    void setUp() {
        Game game = Game.builder().gameName("LOL").build();
        Mockito.when(gameRepo.findByGameNameIgnoreCase("LOL")).thenReturn(game);
    }
    @Test
    @DisplayName("Get data based on Valida game name")
    public void whenValidGameName_thenGameShouldFound(){
        String gameName = "LOL";
        Game found = gameService.getGameByName(gameName);

        assertEquals(gameName, found.getGameName());
    }
}