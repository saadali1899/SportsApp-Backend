package com.example.sportsappbackend.repository;

import com.example.sportsappbackend.model.InterestedSports;
import com.example.sportsappbackend.model.Sports;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestedSportsRepository extends JpaRepository<InterestedSports,Long>{
    List<InterestedSports> findAllByPlayerID(long id);
    void deleteAllByPlayerID(long id);
}
