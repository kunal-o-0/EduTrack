package com.app.dto.transaction;

import java.sql.Timestamp;

import com.app.entities.secondary.Fees;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class TransDto {
	@JsonProperty(access = Access.READ_ONLY)
	private long transId;
	private double transAmount;
	private Timestamp transTimestamp;
	private long feesId;
}
