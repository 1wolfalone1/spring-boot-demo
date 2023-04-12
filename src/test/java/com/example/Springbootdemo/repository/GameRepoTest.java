package com.example.Springbootdemo.repository;

import com.example.Springbootdemo.entity.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class GameRepoTest {

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        Game game = Game.builder().gameName("ahii").build();
        entityManager.persist(game);
        Game game2 = Game.builder().gameName("ahiiii").build();
        entityManager.persist(game2);

    }
    @Test
    public void whenFindById_thenReturnGame(){
       Game game = gameRepo.findById(2).get();

       assertEquals(game.getGameName(), "ahiiii");
    }




}