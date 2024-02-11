package com.app.entities.secondary;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Transaction")
@Data
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trans_id")
	private long transId;
	
	@Column(name="amount")
	private double transAmount;
	
	@Column(name="timestamp")
	private Timestamp transTimestamp;
}
