package com.example.sportsappbackend.service.impl;

import com.example.sportsappbackend.exception.ResourceNotFoundException;
import com.example.sportsappbackend.model.Sports;
import com.example.sportsappbackend.model.Team;
import com.example.sportsappbackend.repository.SportsRepository;
import com.example.sportsappbackend.repository.TeamRepository;
import com.example.sportsappbackend.service.SportsService;
import com.example.sportsappbackend.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        super();
        this.teamRepository = teamRepository;
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(long id) {
        return teamRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Team", "Id", id));
    }

    @Override
    public Team updateTeam(Team team, long id) {
        Team existingTeam = teamRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Team", "Id", id));

        existingTeam.setIsactive(team.getIsactive());
        existingTeam.setCreated(team.getCreated());
        existingTeam.setUpdated(team.getUpdated());
        existingTeam.setValue(team.getValue());
        existingTeam.setName(team.getName());
        existingTeam.setCaptain_id(team.getCaptain_id());
        existingTeam.setTeam_sport(team.getTeam_sport());
        existingTeam.setMatch_played(team.getMatch_played());
        existingTeam.setMatch_won(team.getMatch_won());
        existingTeam.setMatch_lost(team.getMatch_lost());
        existingTeam.setLatitude(team.getLatitude());
        existingTeam.setLongitude(team.getLongitude());
        existingTeam.setDescription(team.getDescription());
        existingTeam.setImage_address(team.getImage_address());
        teamRepository.save(existingTeam);
        return existingTeam;
    }

    @Override
    public void deleteTeam(long id) {
        teamRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Team", "Id", id));
        teamRepository.deleteById(id);
    }
}
