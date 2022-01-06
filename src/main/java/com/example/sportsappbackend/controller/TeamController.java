package com.example.sportsappbackend.controller;


import com.example.sportsappbackend.model.Sports;
import com.example.sportsappbackend.model.Team;
import com.example.sportsappbackend.service.SportsService;
import com.example.sportsappbackend.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

	private TeamService teamService;

	public TeamController(TeamService teamService) {
		super();
		this.teamService = teamService;
	}
	
	// build create user REST API
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Team> saveTeam(@RequestBody Team team){
		return new ResponseEntity<Team>(teamService.saveTeam(team), HttpStatus.CREATED);
	}

	// build get all user REST API
	@GetMapping
	public List<Team> getAllTeams(){
		return teamService.getAllTeams();
	}
	
	// build get user by id REST API
	// http://localhost:8080/api/user/1
	@GetMapping("{id}")
	public ResponseEntity<Team> getTeamById(@PathVariable("id") long teamId){
		return new ResponseEntity<Team>(teamService.getTeamById(teamId), HttpStatus.OK);
	}
	
	// build update user REST API
	// http://localhost:8080/api/user/1
	@PutMapping("{id}")
	public ResponseEntity<Team> updateTeam(@PathVariable("id") long id
												  ,@RequestBody Team team){
		return new ResponseEntity<Team>(teamService.updateTeam(team, id), HttpStatus.OK);
	}
	
	// build delete user REST API
	// http://localhost:8080/api/user/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTeam(@PathVariable("id") long id){
		
		// delete user from DB
		teamService.deleteTeam(id);
		
		return new ResponseEntity<String>("Team deleted successfully!.", HttpStatus.OK);
	}
	
}
