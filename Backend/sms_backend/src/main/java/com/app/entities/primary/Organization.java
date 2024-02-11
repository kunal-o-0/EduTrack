package com.app.entities.primary;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Organization")
@Data
@NoArgsConstructor
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="org_id")
	private long orgId;
	
	@Column(name = "name", length = 100)
	private String orgName;
	
	@Column(name="org_type",length = 100)
	private String orgType;
	
	@Column(name = "address")
	private String orgAddress;
	
	@OneToMany(mappedBy = "organization",cascade = CascadeType.ALL)
	private List<Student> students;
	
	@OneToMany(mappedBy = "organization",cascade = CascadeType.ALL)
	private List<Faculty> faculty;
	
	@OneToMany(mappedBy = "organization",cascade = CascadeType.ALL)
	private List<Staff> staff;
	
	@OneToOne(mappedBy = "organization")
	private Head head;
}
