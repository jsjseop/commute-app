package com.group.commute_app.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group.commute_app.member.domain.Member;
import com.group.commute_app.member.dto.request.MemberSaveRequest;
import com.group.commute_app.member.dto.response.MemberResponse;
import com.group.commute_app.member.repository.MemberRepository;
import com.group.commute_app.team.domain.Team;
import com.group.commute_app.team.repository.TeamRepository;

@Service
public class MemberService {

	private final MemberRepository memberRepository;
	private final TeamRepository teamRepository;

	public MemberService(MemberRepository memberRepository, TeamRepository teamRepository) {
		this.memberRepository = memberRepository;
		this.teamRepository = teamRepository;
	}

	public void saveMember(MemberSaveRequest request) {
		Team team = teamRepository.findByName(request.getTeamName())
			.orElseThrow(IllegalArgumentException::new);

		Member member = new Member(
			request.getName(),
			request.getIsManager(),
			request.getWorkStartDate(),
			request.getBirthday(),
			team);
		memberRepository.save(member);
	}

	public List<MemberResponse> getMembers() {
		List<Member> members = memberRepository.findAll();
		return members.stream()
			.map(member -> new MemberResponse(
				member.getName(),
				member.getTeam().getName(),
				member.isManager(),
				member.getBirthday(),
				member.getWorkStartDate()
			))
			.toList();
	}
}
