package com.app.entities.primary;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.entities.secondary.Address;
import com.app.entities.secondary.Subject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Faculty")
@Data
@NoArgsConstructor
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fac_id")
	private long facId;
	
	@Column(name="f_name",length = 50)
	private String facFName;
	
	@Column(name="m_name",length = 50)
	private String facMName;
	
	@Column(name="l_name",length = 50)
	private String facLName;
	
	@Column(name="mob_no",length = 15)
	private String facMobNo;
	
	@Column(name="address")
	@Embedded
	private Address facAddress;
	
	@Column(name="qualification",length = 50)
	private String facQualif;
	
	@Column(length = 60,unique = true)
	private String email;
	
	@Column(length = 90)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "org_id",nullable = false)
	private Organization organization;
	
	@ManyToMany
	@JoinTable(name = "faculty_subject",
				joinColumns = @JoinColumn(name="fac_id"),
				inverseJoinColumns = @JoinColumn(name="sub_id"))
	private List<Subject> subjects;
}
