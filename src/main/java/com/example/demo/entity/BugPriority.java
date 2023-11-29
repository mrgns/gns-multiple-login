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
@Getter
@Setter
@Table(name = "tlms_priority")
public class BugPriority extends TableOperation  {


	private static final long serialVersionUID = -8127834904652587208L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "priority_id")
	private Integer  priorityId;
	
	@Column(name = "priority_type")
	private String  priority; 
	
}
