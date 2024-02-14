package com.app.dto.head;

import com.app.entities.primary.Organization;
import com.app.entities.secondary.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class HeadDto {
	@JsonProperty(access=Access.READ_ONLY)
	private long headId;
	private String headFName;
	private String headMName;
	private String headLName;
	private String headMobNo;
	private Address headAddress;
	private String headQualif;
	private String email;
	private String password;
	private long orgId;
}
