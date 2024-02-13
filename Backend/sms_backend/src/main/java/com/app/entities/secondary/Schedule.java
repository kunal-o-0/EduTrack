package com.app.entities.secondary;

import java.sql.Time;
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
	private Time schedTime;
	
	@OneToMany(mappedBy = "schedule")
	private List<Attendance> attendances;
	
	@ManyToOne
	@JoinColumn(name="sub_id",nullable=false)
	private Subject subject;
}
