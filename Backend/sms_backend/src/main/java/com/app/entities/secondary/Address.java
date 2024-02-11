package com.app.entities.secondary;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address {
	@Column(name = "address_line",length=150)
	private String addressLine;
	
	@Column(length = 60)
	private String city;
	
	@Column(length = 50)
	private String state;
	
	@Column(length = 50)
	private String country;
	
	private long pincode;
}
