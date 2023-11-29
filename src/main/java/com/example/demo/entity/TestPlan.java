package com.example.demo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ganesh Shinde
 * @version 1.0
 * @Date 05-04-2023 
 */

@Data
@Setter
@Getter
@Entity
@Table(name="tlms_test_plan")
public class TestPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="test_plan_id")
	private int id;
	
	@Column(name="tp_version")
	private String testPlanVersion;
	
	@Column(name="introduction")
	private String introduction;
	
	
	@Column(name="in_scope")
	private String inScope;
	
	@Column(name="out_scope")
	private String outScope;
	
	@Column(name="quality_objective")
	private String qualityObjective;
	
	@Column(name="roles_and_responsibilities")
	private String roleAndResponsibilities;
	
	
	@Column(name="test_methodol_overview")
	private String methodology;
	
	
	@Column(name="test_levels")
	private String testlevel;
	
	@Column(name="bug_triage")
	private String bugTringe;
	
	@Column(name="test_completeness")
	private String testCompleteness;
	
	@Column(name="test_deliverables")
	private String resource;
	
	@Column(name="testing_tools")
	private String testingTools;
	
	@Column(name="test_environment")
	private String testEnvironment;
	
	@Column(name="terms")
	private String terms;
	
	@Column(name="created_by")
	private int created_by;
	
	@Column(name="created_date")
	private LocalDateTime created_date;
	
	@Column(name="updated_by")
	private int updated_by;
	
	@Column(name="updated_date")
	private String updated_date; 
	
	@Column(name="deleted_by")
	private int deleted_by;  
	
	@Column(name="deleted_date")
	private String deleted_date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	@JsonIgnore
	private ProjectMaster project;
	
	@Transient
	private String projectName;
	
	@Transient
	private String newTag;
}
