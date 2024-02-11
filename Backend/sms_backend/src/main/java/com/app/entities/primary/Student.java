package com.app.entities.primary;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.entities.secondary.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Student")
@Data
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stud_id")
	private long studId;
	
	@Column(name="f_name",length = 50)
	private String studFName;
	
	@Column(name="m_name",length = 50)
	private String studMName;
	
	@Column(name="l_name",length = 50)
	private String studLName;
	
	@Column(name="mother_name",length = 50)
	private String studMotherName;
	
	@Column(name="roll_no")
	private long studRollNo;
	
	@Column(name="mob_no",length = 15)
	private String studMobNo;
	
	@Column(name="address")
	private String studAddress;
	
	@Column(name="blood_group",length = 10)
	private String studBloodGrp;
	
	@Column(name="aadhaar_no",length = 20)
	private String studAadhaarNo;
	
	@Column(length = 60)
	private String email;
	
	@Column(length = 90)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "org_id",nullable = false)
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="course_id",nullable = false)
	private Course course;
}
