package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
/**
 * @author Dhanashri Kad
 * @Date 29th Nov 2022
 */

@Entity
@Setter
@Getter
@Table(name = "tlms_severity")
public class BugSeverity extends TableOperation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2514481995613424652L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "severity_id")
	private Integer severityId;
	
	
	@Column(name = "severity_type")
	private String severity;

}
