package com.app.dto.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class CourseDto {
	@JsonProperty(access=Access.READ_ONLY)
	private long courseId;
	private String courseName;
}
