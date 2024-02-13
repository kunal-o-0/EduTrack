package com.app.dto.fees;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class FeesDto {
	@JsonProperty(access = Access.READ_ONLY)
	private long feesId;
	private String feesType;
	private double feesTotal;
	private double feesPaid;
	private long studId;
}
