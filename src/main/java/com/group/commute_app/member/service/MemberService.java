package com.group.commute_app.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.group.commute_app.member.domain.Member;
import com.group.commute_app.member.dto.request.MemberSaveRequest;
import com.group.commute_app.member.dto.response.MemberResponse;
import com.group.commute_app.member.repository.MemberRepository;

@Service
public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void saveMember(MemberSaveRequest request) {
		Member member = new Member(request.getName(), request.isManager(), request.getEmployeeDate(),
			request.getBirthdayDate());
		memberRepository.save(member);
	}

	public List<MemberResponse> getMembers() {
		List<Member> members = memberRepository.findAll();
		return members.stream()
			.map(member -> new MemberResponse(
				member.getName(),
				member.getTeam().getName(),
				member.isManager(),
				member.getBirthdayDate(),
				member.getEmploymentDate()
			))
			.collect(Collectors.toList());
	}
}
