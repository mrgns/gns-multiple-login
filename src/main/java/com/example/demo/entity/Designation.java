package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "designation_master")
public class Designation extends TableOperation {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2225764888993245735L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "designation_id")
	private Integer id;
	private String designation;

	@OneToOne(mappedBy = "designation",fetch = FetchType.LAZY)
	private EmployeeMaster employeeMaster;

}
