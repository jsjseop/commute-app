package com.group.commute_app.team.domain;

import java.util.ArrayList;
import java.util.List;

import com.group.commute_app.member.domain.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<>();

	protected Team() {
	}

	public Team(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Member> getMembers() {
		return members;
	}
}
