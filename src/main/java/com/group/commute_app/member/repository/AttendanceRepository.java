package com.group.commute_app.member.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group.commute_app.member.domain.Attendance;
import com.group.commute_app.member.dto.response.WorkingMinutesDetail;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	@Query("SELECT a FROM Attendance a "
			+ "WHERE a.member.id = :memberId "
			+ "AND FUNCTION('DATE', a.checkInTime) = :checkInDate "
			+ "AND a.checkOutTime IS NULL")
	Optional<Attendance> findByMemberIdAndCheckInTimeAndCheckOutTimeIsNull(
		@Param("memberId") Long memberId,
		@Param("checkInDate") LocalDate checkInDate
	);

	@Query(value = "SELECT DATE(a.check_in_time) AS date, "
		+ "SUM(TIMESTAMPDIFF(MINUTE, a.check_in_time, a.check_out_time)) AS workingMinutes "
		+ "FROM attendance a "
		+ "WHERE a.member_id = :memberId "
		+ "AND YEAR(a.check_in_time) = :year AND MONTH(a.check_in_time) = :month "
		+ "GROUP BY DATE(a.check_in_time)", nativeQuery = true)
	List<WorkingMinutesDetail> findMonthlyWorkingMinutes(
		@Param("memberId") Long memberId,
		@Param("year") int year,
		@Param("month") int month);
}
