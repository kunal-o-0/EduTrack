package com.app.dto.student;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.app.entities.secondary.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class StudDto {
	@JsonProperty(access = Access.READ_ONLY)
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
	@Email
	private String email;
	private String password;
	@NotNull
	private long orgId;
	@NotNull
	private long courseId;
}
