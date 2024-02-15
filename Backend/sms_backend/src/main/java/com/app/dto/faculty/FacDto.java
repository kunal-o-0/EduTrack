package com.app.dto.faculty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.app.entities.secondary.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class FacDto {
	@JsonProperty(access=Access.READ_ONLY)
	private long facId;
	private String facFName;
	private String facMName;
	private String facLName;
	private String facMobNo;
	private Address facAddress;
	private String facQualif;
	@Email
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private long orgId;
}
