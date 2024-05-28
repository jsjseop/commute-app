package com.group.commute_app.member.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.commute_app.member.domain.Attendance;
import com.group.commute_app.member.domain.Member;
import com.group.commute_app.member.dto.request.MemberCheckInRequest;
import com.group.commute_app.member.dto.request.MemberCheckOutRequest;
import com.group.commute_app.member.dto.request.MemberSaveRequest;
import com.group.commute_app.member.dto.response.MemberResponse;
import com.group.commute_app.member.dto.response.MonthlyWorkingMinutesResponse;
import com.group.commute_app.member.dto.response.WorkingMinutesDetail;
import com.group.commute_app.member.repository.AttendanceRepository;
import com.group.commute_app.member.repository.MemberRepository;
import com.group.commute_app.team.domain.Team;
import com.group.commute_app.team.repository.TeamRepository;

@Service
public class MemberService {

	private final TeamRepository teamRepository;
	private final MemberRepository memberRepository;
	private final AttendanceRepository attendanceRepository;

	public MemberService(TeamRepository teamRepository, MemberRepository memberRepository,
		AttendanceRepository attendanceRepository) {
		this.teamRepository = teamRepository;
		this.memberRepository = memberRepository;
		this.attendanceRepository = attendanceRepository;
	}

	@Transactional
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

	@Transactional
	public void checkInMember(MemberCheckInRequest request) {
		Member member = memberRepository.findById(request.getId())
			.orElseThrow(IllegalArgumentException::new);

		// 현재 일자에 출근한 기록이 있는지 확인
		attendanceRepository.findByMemberIdAndCheckInTimeAndCheckOutTimeIsNull(member.getId(), LocalDate.now())
			.ifPresent(attendance -> {
				throw new IllegalArgumentException("이미 출근했습니다;;");
			});

		attendanceRepository.save(new Attendance(member, LocalDateTime.now()));
	}

	@Transactional
	public void checkOutMember(MemberCheckOutRequest request) {
		Member member = memberRepository.findById(request.getId())
			.orElseThrow(IllegalArgumentException::new);

		// 현재 일자에 출근한 기록이 없는 경우 예외 발생
		Attendance attendance = attendanceRepository.findByMemberIdAndCheckInTimeAndCheckOutTimeIsNull(
				member.getId(),
				LocalDate.now())
			.orElseThrow(IllegalArgumentException::new);

		attendance.checkOut(LocalDateTime.now());
	}

	public MonthlyWorkingMinutesResponse getMonthlyWorkingMinutes(Long id, String yearMonth) {
		Member member = memberRepository.findById(id)
			.orElseThrow(IllegalArgumentException::new);

		int year = Integer.parseInt(yearMonth.substring(0, 4));
		int month = Integer.parseInt(yearMonth.substring(5, 7));
		List<WorkingMinutesDetail> monthlyWorkingMinutes = attendanceRepository.findMonthlyWorkingMinutes(
			member.getId(), year, month);

		return new MonthlyWorkingMinutesResponse(monthlyWorkingMinutes);
	}
}
