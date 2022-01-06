package com.example.sportsappbackend.service;

import com.example.sportsappbackend.model.Player;
import com.example.sportsappbackend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PlayerService {
	Player savePlayer(Player player);
	List<Player> getAllPlayers();
	Player getPlayerById(long id);
	Player updatePlayer(Player player, long id);
	Player getPlayerByUsernameAndPassword(String username, String password);
	void deletePlayer(long id);
}
