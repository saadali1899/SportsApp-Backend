package com.example.sportsappbackend.service.impl;

import com.example.sportsappbackend.exception.ResourceNotFoundException;
import com.example.sportsappbackend.model.Team;
import com.example.sportsappbackend.model.TeamMember;
import com.example.sportsappbackend.repository.TeamMemberRepository;
import com.example.sportsappbackend.repository.TeamRepository;
import com.example.sportsappbackend.service.TeamMemberService;
import com.example.sportsappbackend.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {
    private TeamMemberRepository teamMemberRepository;

    public TeamMemberServiceImpl(TeamMemberRepository teamMemberRepository) {
        super();
        this.teamMemberRepository = teamMemberRepository;
    }

    @Override
    public TeamMember saveTeamMember(TeamMember teamMember) {

        return teamMemberRepository.save(teamMember);
    }

    @Override
    public List<TeamMember> getAllTeamMembers() {

        return teamMemberRepository.findAll();
    }

    @Override
    public TeamMember getTeamMemberById(long id) {
        return teamMemberRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("TeamMember", "Id", id));
    }

    @Override
    public TeamMember updateTeamMember(TeamMember teamMember, long id) {
        TeamMember existingTeamMember = teamMemberRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("TeamMember", "Id", id));

        existingTeamMember.setTeamID(teamMember.getTeamID());
        existingTeamMember.setPlayerID(teamMember.getPlayerID());
        teamMemberRepository.save(existingTeamMember);
        return existingTeamMember;
    }

    @Override
    public void deleteTeamMember(long id) {
        teamMemberRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("TeamMember", "Id", id));
        teamMemberRepository.deleteById(id);
    }
}
