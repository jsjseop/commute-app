package com.group.commute_app.member.dto.response;

import java.time.LocalDate;

public class MemberResponse {

	private String name;
	private String teamName;
	private String role;
	private LocalDate birthday;
	private LocalDate workStartDate;

	public MemberResponse(String name, String teamName, boolean isManager, LocalDate birthday, LocalDate workStartDate) {
		this.name = name;
		this.teamName = teamName;
		this.birthday = birthday;
		this.workStartDate = workStartDate;
		if (isManager) {
			this.role = "MANAGER";
		} else {
			this.role = "MEMBER";
		}
	}
}
