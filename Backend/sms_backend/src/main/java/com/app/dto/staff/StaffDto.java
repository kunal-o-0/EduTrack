package com.app.dto.staff;

import com.app.entities.primary.Organization;
import com.app.entities.secondary.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class StaffDto {
	@JsonProperty(access=Access.READ_ONLY)
	private long staffId;
	private String staffFName;
	private String staffMName;
	private String staffLName;
	private String staffMobNo;
	private Address staffAddress;
	private String staffQualif;
	private String staffCategory;
	private String email;
	private String password;
	private long orgId;
}
