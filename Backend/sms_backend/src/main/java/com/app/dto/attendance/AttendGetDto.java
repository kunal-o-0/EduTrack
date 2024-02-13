package com.app.dto.attendance;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AttendGetDto {
	private long attendId;
	private Timestamp attdenTimestamp;
	private long studId;
	private long schedId;
}
