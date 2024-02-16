package com.app.dto.student;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class StudAttendDto {
	private long attendId;
	private Timestamp attdenTimestamp;
}
