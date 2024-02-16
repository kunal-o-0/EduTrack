package com.app.entities.secondary;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.entities.primary.Student;
import com.app.util.AttendanceStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Attendance")
@Data
@NoArgsConstructor
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="attend_id")
	private long attendId;
	
	@Enumerated
	@Column(name = "status")
	private AttendanceStatus attendStatus;
	
	@Column(name="timestamp")
	private Timestamp attdenTimestamp;
	
	@ManyToOne
	@JoinColumn(name="stud_id",nullable=false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "sched_id",nullable=false)
	private Schedule schedule;
}
