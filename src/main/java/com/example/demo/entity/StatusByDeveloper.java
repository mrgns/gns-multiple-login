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
@Table(name = "tlms_status_by_developer")
public class StatusByDeveloper extends TableOperation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8817618736596112910L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sts_by_dev_id")
	private Integer statusDeveloperId;
		
	@Column(name = "sts_by_dev")
    private String statusByDeveloper;

}
