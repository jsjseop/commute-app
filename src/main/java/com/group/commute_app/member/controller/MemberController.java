package com.group.commute_app.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.commute_app.member.dto.request.MemberCheckInRequest;
import com.group.commute_app.member.dto.request.MemberSaveRequest;
import com.group.commute_app.member.dto.response.MemberResponse;
import com.group.commute_app.member.service.MemberService;

@RestController
public class MemberController {

	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/api/member")
	public void saveMember(@RequestBody MemberSaveRequest request) {
		memberService.saveMember(request);
	}

	@GetMapping("/api/member")
	public List<MemberResponse> getMembers() {
		return memberService.getMembers();
	}

	@PostMapping("/api/member/check-in")
	public void checkInMember(@RequestBody MemberCheckInRequest request) {
		memberService.checkInMember(request);
	}
}
