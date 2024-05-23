package com.group.commute_app.member.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.commute_app.member.dto.request.MemberSaveRequest;
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
}
