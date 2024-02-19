package com.app.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class StudLoginDto {
	private String email;
	private String password;
}
