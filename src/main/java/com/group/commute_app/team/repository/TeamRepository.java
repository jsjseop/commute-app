package com.group.commute_app.team.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.commute_app.team.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	Optional<Team> findByName(String name);
}
