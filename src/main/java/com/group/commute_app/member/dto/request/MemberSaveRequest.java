package com.group.commute_app.member.dto.request;

import java.time.LocalDate;

public class MemberSaveRequest {

	private String name;
	private boolean isManager;
	private LocalDate employeeDate;
	private LocalDate birthdayDate;

	public String getName() {
		return name;
	}

	public boolean isManager() {
		return isManager;
	}

	public LocalDate getEmployeeDate() {
		return employeeDate;
	}

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}
}
