package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "project")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "projectID")
public class ProjectMaster implements Serializable {

	private static final long serialVersionUID = -8211691251271980362L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Project_ID")
	private Integer projectID;


	@Column(name = "Project_Name")
	private String projectName;
	
	@Column(name = "project_alias")
	private String projectAlias;

	@Column(name = "Service_id")
	private Integer serviceId;

	@Column(name = "Engagement_Model")
	private String engagementModel;

	@Column(name = "Efforts")
	private Integer efforts;

	@Column(name = "Efforts_unit")
	private Character effortsUnit;

	@Column(name = "Start_Date")
	private LocalDateTime startDate;

	@Column(name = "End_Date")
	private LocalDateTime endDate;

	@Column(name = "Execution_Model")
	private String executionModel;

	@Column(name = "Project_Manager")
	private Integer projectManager;

	@Column(name = "Percent_Of_Allocation_Of_Manager")
	private Integer percentOfAllocationOfManager;

	@Column(name = "Project_Status")
	private Character projectStatus;
	
	@Column(name = "project_phase")
	private String projectPhase;

	
	@Column(name = "SOW_Signed")
	private Character SOWSigned;



	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_date")
	private Date updatedDate;

	
	@Column(name = "deleted_by")
	private String deletedBy;

	@Column(name = "deleted_date")
	private Date deletedDate;
	 
	
	@Transient
	private Integer bug;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Customer_ID")
	@JsonBackReference(value = "clientMaster")
	private ClientMaster clientmaster;

	@OneToMany(mappedBy = "projectMaster", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<ProjectTeam> projectTeam = new HashSet<ProjectTeam>();

	@OneToMany(mappedBy = "projectMaster", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TestScenario> testScenarios = new ArrayList<TestScenario>();

	@OneToMany(mappedBy = "projectMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Rtm> rtm = new ArrayList<Rtm>();

	@OneToMany(mappedBy = "projectMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<TestScript> testScript = new ArrayList<TestScript>();

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<TestCase> testCase = new ArrayList<TestCase>();
	
	
	@OneToMany(mappedBy = "projectMaster", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TestResult> testResult = new ArrayList<TestResult>();


}
