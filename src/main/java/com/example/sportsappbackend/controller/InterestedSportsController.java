package com.example.sportsappbackend.controller;


import com.example.sportsappbackend.model.InterestedSports;
import com.example.sportsappbackend.model.Sports;
import com.example.sportsappbackend.service.InterestedSportsService;
import com.example.sportsappbackend.service.SportsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interestedSports")
public class InterestedSportsController {

	private InterestedSportsService interestedSportsService;

	public InterestedSportsController(InterestedSportsService interestedSportsService) {
		super();
		this.interestedSportsService = interestedSportsService;
	}
	
	// build get all user REST API
	@GetMapping
	public List<InterestedSports> getAllInterestedSports(){
		return interestedSportsService.getAllInterestedSports();
	}

	// build get user by id REST API
	// http://localhost:8080/api/user/1
	@GetMapping("{id}")
	public List<InterestedSports> getAllInterestedSportsById(@PathVariable("id") long Id){
		return interestedSportsService.getInterestedSportsById(Id);
	}

}
