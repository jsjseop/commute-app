package com.group.commute_app.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.commute_app.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
