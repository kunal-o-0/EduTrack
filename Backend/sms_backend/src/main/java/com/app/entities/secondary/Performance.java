package com.app.entities.secondary;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
