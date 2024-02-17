package com.app.dto.student;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class StudGetTransDto {
	private long transId;
	private String transDetails;
	private double transAmount;
	private Timestamp transTimestamp;
	private String feesType;
}
