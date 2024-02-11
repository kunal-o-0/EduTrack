package com.app.entities.secondary;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.entities.primary.Student;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Course")
@Data
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private long courseId;
	
	@Column(name="name",length = 70)
	private String courseName;
	
	@OneToMany(mappedBy = "course")
	private List<Student> students;
	
	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
	private List<Subject> subjects;
}
