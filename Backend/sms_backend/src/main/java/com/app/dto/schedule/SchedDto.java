package com.app.dto.schedule;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class SchedDto {
	@JsonProperty(access=Access.READ_ONLY)
	private long schedId;
	private Date schedDate;
	private Time schedTime;
	private long subId;
}
