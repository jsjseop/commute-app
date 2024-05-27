package com.group.commute_app.member.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group.commute_app.member.domain.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	@Query("SELECT a FROM Attendance a "
			+ "WHERE a.member.id = :memberId "
			+ "AND FUNCTION('DATE', a.checkInTime) = :checkInDate "
			+ "AND a.checkOutTime IS NULL")
	Optional<Attendance> findByMemberIdAndCheckInTimeAndCheckOutTimeIsNull(
		@Param("memberId") Long memberId,
		@Param("checkInDate") LocalDate checkInDate
	);
}
