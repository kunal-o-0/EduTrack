package com.app.dto.student;

import lombok.Data;

@Data
public class StudPerfDto {
	private long perfId;
	private String subName;
	private long marksObtained;
	private int subTotalMarks;
	private String grades;
}
