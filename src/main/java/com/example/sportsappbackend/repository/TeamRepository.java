package com.example.sportsappbackend.repository;

import com.example.sportsappbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long>{
}
