package com.example.Springbootdemo.repository;

import com.example.Springbootdemo.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepo extends JpaRepository<Game, Integer> {
    Game findByGameName(String name);
    Game findByGameNameIgnoreCase(String name);

    @Query(value = "Select id, name from games where name like %?1%", nativeQuery = true)
    List<Game> filterByName(String name);
}
