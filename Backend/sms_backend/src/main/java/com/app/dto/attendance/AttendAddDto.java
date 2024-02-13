package com.app.dto.attendance;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AttendAddDto {
	private Timestamp attdenTimestamp;
	private long studId;
	private long schedId;
}
