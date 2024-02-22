package com.app.dto.staff;

import lombok.Data;

@Data
public class StaffAfterLoginDto {
	private long staffId;
	private String staffFName;
	private String staffMName;
	private String staffLName;
	private String staffCategory;
}
