package com.app.util;

import java.util.List;

import lombok.Data;

@Data
public class CreatePayload <T>{
	private String message;
	private List<T> payload;
	
	public CreatePayload(String message,List<T> payload)
	{
		this.message=message;
		this.payload=payload;
	}
}
