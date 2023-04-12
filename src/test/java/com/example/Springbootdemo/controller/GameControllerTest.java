package com.example.Springbootdemo.controller;

import com.example.Springbootdemo.entity.Game;
import com.example.Springbootdemo.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(GameController.class)
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    private Game game;

    @BeforeEach
    void setUp() {
        game = Game.builder().gameName("LOL").id(1).build();

    }

    @Test
    void saveGame() throws Exception {
        Game inputGame = Game.builder().gameName("LOL").id(1).build();
        Mockito.when(gameService.saveGame(inputGame))
                .thenReturn(game);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/save-game")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" + "   \"gameName\" : \"Dota2\"\n" + "}")
                ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchGameById() throws Exception {
        Mockito.when(gameService.getGameById(1))
                .thenReturn(game);
        mockMvc.perform(MockMvcRequestBuilders.get("/games/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.gameName")
                        .value(game.getGameName()));
    }
}