package com.example.sportsappbackend.service;

import com.example.sportsappbackend.model.Team;
import com.example.sportsappbackend.model.TeamMember;

import java.util.List;

public interface TeamMemberService {
	TeamMember saveTeamMember(TeamMember teamMember);
	List<TeamMember> getAllTeamMembers();
	TeamMember getTeamMemberById(long id);
	TeamMember updateTeamMember(TeamMember teamMember, long id);
	void deleteTeamMember(long id);
}
