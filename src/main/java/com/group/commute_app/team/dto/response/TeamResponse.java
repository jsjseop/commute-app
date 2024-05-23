package com.group.commute_app.team.dto.response;

import java.util.List;

import com.group.commute_app.member.domain.Member;

public class TeamResponse {

	private String name;
	private String manager;
	private int memberCount;

	public TeamResponse(String name, List<Member> members) {
		this.name = name;
		for (Member member : members) {
			if (member.isManager()) {
				this.manager = member.getName();
			}
		}
		this.memberCount = members.size();
	}

	public String getName() {
		return name;
	}

	public String getManager() {
		return manager;
	}

	public int getMemberCount() {
		return memberCount;
	}
}
