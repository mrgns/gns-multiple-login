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
@Table(name = "tlms_defect_type")
public class BugDefectType extends TableOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4091233832941003234L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "defect_type_id")
	private Integer defectTypeId;
	
	@Column(name = "defect_type")
	private String defectType;

}
