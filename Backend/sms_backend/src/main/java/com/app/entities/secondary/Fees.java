package com.app.entities.secondary;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Fees")
@Data
@NoArgsConstructor
public class Fees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fees_id")
	private long feesId;
	
	@Column(name="type",length = 50)
	private String feesType;
	
	@Column(name="total")
	private double feesTotal;
	
	@Column(name="paid")
	private double feesPaid;
}
