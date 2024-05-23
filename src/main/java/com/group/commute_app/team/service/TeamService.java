package com.group.commute_app.team.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.group.commute_app.team.domain.Team;
import com.group.commute_app.team.dto.request.TeamSaveRequest;
import com.group.commute_app.team.dto.response.TeamResponse;
import com.group.commute_app.team.repository.TeamRepository;

@Service
public class TeamService {

	private final TeamRepository teamRepository;

	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	public void saveTeam(TeamSaveRequest request) {
		teamRepository.save(new Team(request.getName()));
	}

	public List<TeamResponse> getTeams() {
		List<Team> teams = teamRepository.findAll();
		return teams.stream()
			.map(team -> new TeamResponse(team.getName(), team.getMembers()))
			.collect(Collectors.toList());
	}
}
