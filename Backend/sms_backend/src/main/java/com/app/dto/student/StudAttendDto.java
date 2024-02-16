package com.app.dto.student;

import java.sql.Timestamp;

import com.app.util.AttendanceStatus;

import lombok.Data;

@Data
public class StudAttendDto {
	private long attendId;
	private AttendanceStatus attendStatus;
	private Timestamp attdenTimestamp;
}
