package com.group.commute_app.member.dto.request;

import java.time.LocalDate;

public class MemberSaveRequest {

	private String name;
	private String teamName;
	private boolean isManager;
	private LocalDate workStartDate;
	private LocalDate birthday;

	public String getName() {
		return name;
	}

	public String getTeamName() {
		return teamName;
	}

	public boolean isManager() {
		return isManager;
	}

	public LocalDate getWorkStartDate() {
		return workStartDate;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
}
