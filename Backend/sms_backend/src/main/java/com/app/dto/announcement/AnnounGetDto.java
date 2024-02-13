package com.app.dto.announcement;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AnnounGetDto {
	private long announId;
	private String announType;
	private String announContent;
	private Timestamp announTimestamp;
	private long orgId;
}
