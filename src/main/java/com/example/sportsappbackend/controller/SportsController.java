package com.example.sportsappbackend.controller;


import com.example.sportsappbackend.model.Player;
import com.example.sportsappbackend.model.Sports;
import com.example.sportsappbackend.service.PlayerService;
import com.example.sportsappbackend.service.SportsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sports")
public class SportsController {

	private SportsService sportsService;

	public SportsController(SportsService sportsService) {
		super();
		this.sportsService = sportsService;
	}
	
	// build create user REST API
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Sports> savePlayer(@RequestBody Sports sports){
		return new ResponseEntity<Sports>(sportsService.saveSports(sports), HttpStatus.CREATED);
	}

	// build get all user REST API
	@GetMapping
	public List<Sports> getAllSports(){
		return sportsService.getAllSports();
	}
	
	// build get user by id REST API
	// http://localhost:8080/api/user/1
	@GetMapping("{id}")
	public ResponseEntity<Sports> getSportsById(@PathVariable("id") long sportsId){
		return new ResponseEntity<Sports>(sportsService.getSportsById(sportsId), HttpStatus.OK);
	}
	
	// build update user REST API
	// http://localhost:8080/api/user/1
	@PutMapping("{id}")
	public ResponseEntity<Sports> updateSports(@PathVariable("id") long id
												  ,@RequestBody Sports sports){
		return new ResponseEntity<Sports>(sportsService.updateSPorts(sports, id), HttpStatus.OK);
	}
	
	// build delete user REST API
	// http://localhost:8080/api/user/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSports(@PathVariable("id") long id){
		
		// delete user from DB
		sportsService.deleteSports(id);
		
		return new ResponseEntity<String>("Sport deleted successfully!.", HttpStatus.OK);
	}
	
}
