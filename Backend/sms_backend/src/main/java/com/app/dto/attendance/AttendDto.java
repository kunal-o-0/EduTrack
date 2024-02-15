package com.app.dto.attendance;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class AttendDto {
	@JsonProperty(access=Access.READ_ONLY)
	private long attendId;
	private Timestamp attdenTimestamp;
	@NotNull
	private long studId;
	@NotNull
	private long schedId;
}
