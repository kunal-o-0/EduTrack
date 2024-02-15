package com.app.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseText {
	@JsonProperty("status")
	private int statusCode;
	@JsonProperty("message")
	private String responseText;
}
