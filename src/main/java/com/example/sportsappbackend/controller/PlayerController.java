package com.example.sportsappbackend.controller;


import com.example.sportsappbackend.model.Player;
import com.example.sportsappbackend.model.User;
import com.example.sportsappbackend.service.PlayerService;
import com.example.sportsappbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

	private PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}
	
	// build create user REST API
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Player> savePlayer(@RequestBody Player player){
		return new ResponseEntity<Player>(playerService.savePlayer(player), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Player player) {
		Player player1 = playerService.getPlayerByUsernameAndPassword(player.getUsername(), player.getPassword());
		if (player1 != null) {
			return new ResponseEntity<String>("User logged in successfully!", HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("No User found",HttpStatus.NOT_FOUND);
	}


	// build get all user REST API
	@GetMapping
	public List<Player> getAllPlayers(){
		return playerService.getAllPlayers();
	}
	
	// build get user by id REST API
	// http://localhost:8080/api/user/1
	@GetMapping("{id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable("id") long playerId){
		return new ResponseEntity<Player>(playerService.getPlayerById(playerId), HttpStatus.OK);
	}
	
	// build update user REST API
	// http://localhost:8080/api/user/1
	@PutMapping("{id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable("id") long id
												  ,@RequestBody Player player){
		return new ResponseEntity<Player>(playerService.updatePlayer(player, id), HttpStatus.OK);
	}
	
	// build delete user REST API
	// http://localhost:8080/api/user/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePlayer(@PathVariable("id") long id){
		
		// delete user from DB
		playerService.deletePlayer(id);
		
		return new ResponseEntity<String>("Player deleted successfully!.", HttpStatus.OK);
	}
	
}
