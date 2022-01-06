package com.example.sportsappbackend.repository;

import com.example.sportsappbackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    Player findByUsernameAndPassword(String username, String password);
}

