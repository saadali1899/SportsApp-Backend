package com.example.sportsappbackend.controller;


import com.example.sportsappbackend.model.Team;
import com.example.sportsappbackend.model.Tournament;
import com.example.sportsappbackend.service.TeamService;
import com.example.sportsappbackend.service.TournamentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournament")
public class TournamentController {

	private TournamentService tournamentService;

	public TournamentController(TournamentService tournamentService) {
		super();
		this.tournamentService = tournamentService;
	}
	
	// build create user REST API
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Tournament> saveTournament(@RequestBody Tournament tournament){
		return new ResponseEntity<Tournament>(tournamentService.saveTournament(tournament), HttpStatus.CREATED);
	}

	// build get all user REST API
	@GetMapping
	public List<Tournament> getAllTournaments(){
		return tournamentService.getAllTournaments();
	}
	
	// build get user by id REST API
	// http://localhost:8080/api/user/1
	@GetMapping("{id}")
	public ResponseEntity<Tournament> getTournamentById(@PathVariable("id") long Id){
		return new ResponseEntity<Tournament>(tournamentService.getTournamentById(Id), HttpStatus.OK);
	}
	
	// build update user REST API
	// http://localhost:8080/api/user/1
	@PutMapping("{id}")
	public ResponseEntity<Tournament> updateTournament(@PathVariable("id") long id
												  ,@RequestBody Tournament tournament){
		return new ResponseEntity<Tournament>(tournamentService.updateTournament(tournament, id), HttpStatus.OK);
	}
	
	// build delete user REST API
	// http://localhost:8080/api/user/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTournament(@PathVariable("id") long id){
		
		// delete user from DB
		tournamentService.deleteTournament(id);
		
		return new ResponseEntity<String>("Team deleted successfully!.", HttpStatus.OK);
	}
	
}
