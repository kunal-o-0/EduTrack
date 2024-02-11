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
@Table(name="Schedule")
@Data
@NoArgsConstructor
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sched_id")
	private long schedId;
	
	@Column(name="date")
	private Date schedDate;
	
	@Column(name="time",length = 20)
	private String schedTime;
}
