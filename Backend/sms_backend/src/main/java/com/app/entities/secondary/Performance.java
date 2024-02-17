package com.app.entities.secondary;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.entities.primary.Student;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Performance")
@Data
@NoArgsConstructor
public class Performance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="perf_id")
	private long perfId;
	
	@Column(name="marks_obtained")
	private long marksObtained;
	
	@Column(name="grades",length = 10)
	private String grades;
	
	@ManyToOne
	@JoinColumn(name="stud_id",nullable=false)
	private Student student;
	
	@OneToOne
	@JoinColumn(name="sub_id",nullable = false)
	private Subject subject;
}
