package com.app.dto.head;

import com.app.entities.secondary.Address;

import lombok.Data;

@Data
public class HeadGetDto {
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
