package com.group.commute_app.member.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.commute_app.member.domain.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	boolean existsByMemberIdAndCheckInTimeAndCheckOutTimeIsNull(Long memberId, LocalDateTime checkInTime);
}
