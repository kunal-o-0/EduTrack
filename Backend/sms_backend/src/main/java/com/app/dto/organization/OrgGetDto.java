package com.app.dto.organization;

import com.app.entities.secondary.Address;

import lombok.Data;

@Data
public class OrgGetDto {
	private long orgId;
	private String orgName;
	private String orgType;
	private Address orgAddress;
	private long headId;
}
