package com.app.dto.organization;

import com.app.entities.secondary.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class OrgDto {
	@JsonProperty(access=Access.READ_ONLY)
	private long orgId;
	private String orgName;
	private String orgType;
	private Address orgAddress;
	@JsonProperty(access = Access.READ_ONLY)
	private long headId;
}
