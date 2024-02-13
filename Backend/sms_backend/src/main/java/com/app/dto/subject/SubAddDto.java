package com.app.dto.subject;

import lombok.Data;

@Data
public class SubAddDto {
	private String subName;
	private int subTotalMarks;
	private long courseId;
}
