package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Rupesh Gawas
 * @Date 20-07-2023
 * @Version 1.0
 */

@Setter
@Getter
@Entity
@Table(name = "use_cases")
public class UseCase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "use_case_id")
	private int useCaseId;
	
	@Column(name = "project_id")
	private String projectId;
	
	@Column(name = "use_case_name")
	private String useCaseName;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(name = "updated_date")
	private String updatedDate;
	
	@Column(name = "deleted_by")
	private String deletedBy;
	
	@Column(name = "deleted_date")
	private String deletedDate;
	
	@OneToMany(mappedBy ="useCase",fetch = FetchType.LAZY)
	private List<RBACMaster> rbacMaster;

}
