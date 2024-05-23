package com.group.commute_app.member.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

	protected Member() {
	}

	public Member(String name, boolean isManager, LocalDate employmentDate, LocalDate birthdayDate) {
		this.name = name;
		this.isManager = isManager;
		this.employmentDate = employmentDate;
		this.birthdayDate = birthdayDate;
	}
}
