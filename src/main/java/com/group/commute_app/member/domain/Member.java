package com.group.commute_app.member.domain;

import java.time.LocalDate;

import com.group.commute_app.team.domain.Team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private boolean isManager;
	@Column(nullable = false)
	private LocalDate workStartDate;
	@Column(nullable = false)
	private LocalDate birthday;
	@ManyToOne
	private Team team;

	protected Member() {
	}

	public Member(String name, boolean isManager, LocalDate workStartDate, LocalDate birthday, Team team) {
		this.name = name;
		this.isManager = isManager;
		this.workStartDate = workStartDate;
		this.birthday = birthday;
		this.team = team;
	}

	public String getName() {
		return name;
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

	public Team getTeam() {
		return team;
	}
}
