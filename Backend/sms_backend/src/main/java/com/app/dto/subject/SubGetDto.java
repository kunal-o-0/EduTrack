package com.app.dto.subject;

import lombok.Data;

@Data
public class SubGetDto {
	private long subId;
	private String subName;
	private int subTotalMarks;
	private long courseId;
}
