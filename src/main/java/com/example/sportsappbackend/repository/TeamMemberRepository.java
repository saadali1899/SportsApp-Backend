package com.example.sportsappbackend.repository;

import com.example.sportsappbackend.model.Team;
import com.example.sportsappbackend.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember,Long>{
}
