package com.example.sportsappbackend.controller;


import com.example.sportsappbackend.model.Team;
import com.example.sportsappbackend.model.TeamMember;
import com.example.sportsappbackend.service.TeamMemberService;
import com.example.sportsappbackend.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teamMember")
public class TeamMemberController {

	private TeamMemberService teamMemberService;

	public TeamMemberController(TeamMemberService teamMemberService) {
		super();
		this.teamMemberService = teamMemberService;
	}
	
	// build create user REST API
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<TeamMember> saveTeamMember(@RequestBody TeamMember teamMember){
		return new ResponseEntity<TeamMember>(teamMemberService.saveTeamMember(teamMember), HttpStatus.CREATED);
	}

	// build get all user REST API
	@GetMapping
	public List<TeamMember> getAllTeamMembers(){
		return teamMemberService.getAllTeamMembers();
	}
	
	// build get user by id REST API
	// http://localhost:8080/api/user/1
	@GetMapping("{id}")
	public ResponseEntity<TeamMember> getTeamMemberById(@PathVariable("id") long teamMemberId){
		return new ResponseEntity<TeamMember>(teamMemberService.getTeamMemberById(teamMemberId), HttpStatus.OK);
	}
	
	// build update user REST API
	// http://localhost:8080/api/user/1
	@PutMapping("{id}")
	public ResponseEntity<TeamMember> updateTeamMember(@PathVariable("id") long id
												  ,@RequestBody TeamMember teamMember){
		return new ResponseEntity<TeamMember>(teamMemberService.updateTeamMember(teamMember, id), HttpStatus.OK);
	}
	
	// build delete user REST API
	// http://localhost:8080/api/user/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTeamMember(@PathVariable("id") long id){
		
		// delete user from DB
		teamMemberService.deleteTeamMember(id);
		
		return new ResponseEntity<String>("Team deleted successfully!.", HttpStatus.OK);
	}
	
}
