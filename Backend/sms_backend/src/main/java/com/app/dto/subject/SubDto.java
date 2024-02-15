package com.app.dto.subject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class SubDto {
	@JsonProperty(access=Access.READ_ONLY)
	private long subId;
	private String subName;
	private int subTotalMarks;
	@NotNull
	private long courseId;
}
