package com.app.entities.secondary;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.entities.primary.Organization;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Announcement")
@Data
@NoArgsConstructor
public class Announcement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="announ_id")
	private long announId;
		
	@Column(name="type",length = 60)
	private String announType;
	
	@Column(name="content",length = 1000)
	private String announContent;
	
	@Column(name="timestamp")
	private Timestamp announTimestamp;
	
	@ManyToOne
	@JoinColumn(name="org_id",nullable=false)
	private Organization organization;
}
