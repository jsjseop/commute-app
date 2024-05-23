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
	private LocalDate employmentDate;
	@Column(nullable = false)
	private LocalDate birthdayDate;
	@ManyToOne
	private Team team;

	protected Member() {
	}

	public Member(String name, boolean isManager, LocalDate employmentDate, LocalDate birthdayDate) {
		this.name = name;
		this.isManager = isManager;
		this.employmentDate = employmentDate;
		this.birthdayDate = birthdayDate;
	}

	public String getName() {
		return name;
	}

	public boolean isManager() {
		return isManager;
	}

	public LocalDate getEmploymentDate() {
		return employmentDate;
	}

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

	public Team getTeam() {
		return team;
	}
}
