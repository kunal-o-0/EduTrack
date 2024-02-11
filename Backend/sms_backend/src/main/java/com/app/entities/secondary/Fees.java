package com.app.entities.secondary;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.entities.primary.Student;

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
	
	@ManyToOne
	@JoinColumn(name="stud_id",nullable=false)
	private Student student;
	
	@OneToMany(mappedBy = "fees")
	private List<Transaction> transactions;
}
