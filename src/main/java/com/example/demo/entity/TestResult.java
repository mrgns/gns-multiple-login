package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tlms_test_result")
public class TestResult extends TableOperation {

	private static final long serialVersionUID = 6992035487424454475L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_result_id")
	private Integer testResultId;

	@Column(name = "actual_result")
	private String actualResult;

	@Column(name = "result_status")
	private String resultStatus;

	@Transient
	MultipartFile photo;

	@Column(name = "result_screenshot")
	private String resultScreenshot;

	@Column(name = "created_date ")
	private LocalDateTime createdDate;

	@Column(name = "updated_by ")
	private Integer updatedBy;

	@Column(name = "updated_date ")
	private LocalDateTime updatedDate;
	
	@Column(name = "image_name ")
	private String imageName; 
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private ProjectMaster projectMaster;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rtm_id")
	private Rtm rtm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "case_id")
	@JsonBackReference
	private TestCase testCase;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scenario_id")
	private TestScenario testScenario;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinColumn(name = "status_id")
	private Status sheetstatus;
	
	
	@OneToMany(mappedBy = "testResult",fetch=FetchType.LAZY)
	private List<Bug> bug=new ArrayList<>();

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "test_script_id")
	private TestScript testScript;

	@OneToOne
	@JoinColumn(name = "project_team_id")
	private ProjectTeam projectTeam;
	
}
