package com.app.entities.primary;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.entities.secondary.Address;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Staff")
@Data
@NoArgsConstructor
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="staff_id")
	private long staffId;
	
	@Column(name="f_name",length = 50)
	private String staffFName;
	
	@Column(name="m_name",length = 50)
	private String staffMName;
	
	@Column(name="l_name",length = 50)
	private String staffLName;
	
	@Column(name="mob_no",length = 15)
	private String staffMobNo;
	
	@Column(name="address")
	@Embedded
	private Address staffAddress;
	
	@Column(name="qualification",length = 50)
	private String staffQualif;
	
	@Column(name="category",length = 50)
	private String staffCategory;
	
	@Column(length = 60)
	private String email;
	
	@Column(length = 90)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "org_id",nullable = false)
	private Organization organization;
}
