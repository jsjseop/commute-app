package com.group.commute_app.member.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Member member;
	@Column(nullable = false)
	private LocalDateTime checkInTime;
	private LocalDateTime checkOutTime;

	protected Attendance() {
	}

	public Attendance(Member member, LocalDateTime checkInTime) {
		this.member = member;
		this.checkInTime = checkInTime;
	}

	public void checkOut(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
}
