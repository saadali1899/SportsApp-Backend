package com.example.sportsappbackend.repository;

import com.example.sportsappbackend.model.Team;
import com.example.sportsappbackend.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament,Long>{
}
