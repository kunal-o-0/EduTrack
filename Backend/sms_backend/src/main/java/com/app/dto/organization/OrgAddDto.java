package com.app.dto.organization;

import com.app.entities.secondary.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class OrgAddDto {
	private String orgName;
	private String orgType;
	private Address orgAddress;
}
