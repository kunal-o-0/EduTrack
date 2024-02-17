package com.app.dto.student;

import lombok.Data;

@Data
public class StudGetPendingFeesDto {
	private long feesId;
	private String feesType;
	private double feesPending;
}
