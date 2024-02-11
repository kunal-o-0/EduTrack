package com.app.entities.secondary;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.entities.primary.Faculty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Subject")
@Data
@NoArgsConstructor
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subject_id")
	private long subId;
	
	@Column(name="name",length=70)
	private String subName;
	
	@Column(name="total_marks")
	private int subTotalMarks;
	
	@ManyToMany(mappedBy = "subjects")
	private List<Faculty> faculties;
	
	@ManyToOne
	@JoinColumn(name="course_id",nullable = false)
	private Course course;
	
	//unidirectional relation inside schedule and performance
}
