package com.group.commute_app.team.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.commute_app.team.dto.request.TeamSaveRequest;
import com.group.commute_app.team.dto.response.TeamResponse;
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

	@GetMapping("/api/team")
	public List<TeamResponse> getTeams() {
		return teamService.getTeams();
	}
}
