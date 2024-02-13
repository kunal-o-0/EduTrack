package com.app.dto.schedule;

import java.sql.Time;
import java.util.Date;

import lombok.Data;

@Data
public class SchedGetDto {
	private long schedId;
	private Date schedDate;
	private Time schedTime;
	private long subId;
}
