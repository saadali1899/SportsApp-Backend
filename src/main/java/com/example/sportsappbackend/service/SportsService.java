package com.example.sportsappbackend.service;

import com.example.sportsappbackend.model.Player;
import com.example.sportsappbackend.model.Sports;

import java.util.List;

public interface SportsService {
	Sports saveSports(Sports sports);
	List<Sports> getAllSports();
	Sports getSportsById(long id);
	Sports updateSPorts(Sports sports, long id);
	void deleteSports(long id);
}
