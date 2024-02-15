package com.app.dto.organization;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OrgAddHeadDto {
	@NotNull
	private long orgId;
	@NotNull
	private long headId;
}
