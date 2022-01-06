package com.example.sportsappbackend.repository;

import com.example.sportsappbackend.model.Sports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsRepository extends JpaRepository<Sports,Long>{
}
