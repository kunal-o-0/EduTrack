package com.app.dto;

import com.app.entities.secondary.Address;

import lombok.Data;

@Data
public class StudentDto {
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
}
