package com.app.dto.faculty;

import com.app.entities.secondary.Address;

import lombok.Data;

@Data
public class FacAddDto {
	private String facFName;
	private String facMName;
	private String facLName;
	private String facMobNo;
	private Address facAddress;
	private String facQualif;
	private String email;
	private String password;
	private long orgId;
}
