package com.example.sportsappbackend.service;

import com.example.sportsappbackend.model.InterestedSports;

import java.util.List;

public interface InterestedSportsService {
	List<InterestedSports> getAllInterestedSports();
	List<InterestedSports> getInterestedSportsById(long id);

}
