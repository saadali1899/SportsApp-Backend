package com.example.sportsappbackend.service;

import com.example.sportsappbackend.model.Team;
import com.example.sportsappbackend.model.Tournament;

import java.util.List;

public interface TournamentService {
	Tournament saveTournament(Tournament tournament);
	List<Tournament> getAllTournaments();
	Tournament getTournamentById(long id);
	Tournament updateTournament(Tournament tournament, long id);
	void deleteTournament(long id);
}
