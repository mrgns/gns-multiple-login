package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Getter
@Setter
@Table(name = "employee_profile")
public class EmployeeProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empProfileId;
	
	@Column(name = "Profile_ID")
	private Integer staffId;
	
	@Column(name = "Profile_picture")
	private String profilePicture;
	
}
