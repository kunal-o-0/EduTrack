package com.app.dto.student;

import com.app.entities.secondary.Address;

import lombok.Data;

@Data
public class StudDto {
	private long studId;
	private String studFName;
	private String studMName;
	private String studLName;
	private String studMotherName;
	private long studRollNo;
	private String studMobNo;
	private String studBloodGrp;
	private Address studAddress;
	private String studAadhaarNo;
	private String email;
	private String password;
	private long orgId;
	private long courseId;
}
