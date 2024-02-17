package com.app.dto.performance;

import javax.validation.constraints.NotNull;

import com.app.entities.primary.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class PerforDto {
	@JsonProperty(access = Access.READ_ONLY)
	private long perfId;
	private long marksObtained;
	private String grades;
	@NotNull
	private long studId;
	@NotNull
	private long subId;
}
