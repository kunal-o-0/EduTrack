package com.app.dto;

import com.app.entities.secondary.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrgAddDto {
	private String orgName;
	private String orgType;
	private Address orgAddress;
}
