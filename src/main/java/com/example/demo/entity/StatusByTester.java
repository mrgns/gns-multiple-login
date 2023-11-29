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
@Table(name = "tlms_status_by_tester")
public class StatusByTester extends TableOperation{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6233385839210761445L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sts_by_tstr_id")
	private Integer statusTesterId;
    
    @Column(name = "sts_by_tstr")
    private String statusByTester;

}
