package com.group.commute_app.member.dto.response;

import java.util.List;

public class MonthlyWorkingMinutesResponse {

	private List<WorkingMinutesDetail> detail;
	private long sum;

	public MonthlyWorkingMinutesResponse(List<WorkingMinutesDetail> workingMinutesDetails) {
		this.detail = workingMinutesDetails;
		for (WorkingMinutesDetail workingMinutesDetail : workingMinutesDetails) {
			this.sum += workingMinutesDetail.getWorkingMinutes();
		}
	}

	public List<WorkingMinutesDetail> getDetail() {
		return detail;
	}

	public long getSum() {
		return sum;
	}
}
