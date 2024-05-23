package com.group.commute_app.team.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.commute_app.team.dto.request.TeamSaveRequest;
import com.group.commute_app.team.service.TeamService;

@RestController
public class TeamController {

	private final TeamService teamService;

	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}

	@PostMapping("/api/team")
	public void saveTeam(TeamSaveRequest request) {
		teamService.saveTeam(request);
	}
}
