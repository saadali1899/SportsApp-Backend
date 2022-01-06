package com.example.sportsappbackend.service;

import com.example.sportsappbackend.model.Sports;
import com.example.sportsappbackend.model.Team;

import java.util.List;

public interface TeamService {
	Team saveTeam(Team team);
	List<Team> getAllTeams();
	Team getTeamById(long id);
	Team updateTeam(Team team, long id);
	void deleteTeam(long id);
}
