package com.group.commute_app.team.service;

import org.springframework.stereotype.Service;

import com.group.commute_app.team.domain.Team;
import com.group.commute_app.team.dto.request.TeamSaveRequest;
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
}
