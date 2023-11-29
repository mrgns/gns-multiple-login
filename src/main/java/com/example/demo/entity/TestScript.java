package com.example.demo.entity;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "tlms_test_script")
public class TestScript implements Serializable {

	private static final long serialVersionUID = 5749228656937900690L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_script_id")
	private int testScriptId;

	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinColumn(name = "status_id")
	private Status sheetstatus;
	
	@Column(name = "test_case_name")
	private String testCaseName;
	
	@Column(name = "test_script_desc")
	private String scriptStepDesc;
	
	@Column(name = "input_data")
	private String inputData;
	
	@Column(name = "expected_result")
	private String expectedResult;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rtm_id")
	@JsonIgnore
	private Rtm rtm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "case_id")
	@JsonIgnore
	public TestCase testCase;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	@JsonIgnore
	private ProjectMaster projectMaster;
	
	@OneToOne(mappedBy = "testScript", fetch = FetchType.LAZY)
	@JsonIgnore
	private TestResult testResult;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scenario_id")
	@JsonIgnore
	public TestScenario testScenario;
	
	@Column(name = "step_no")
	private Integer step_no;
	
	
	@Column(name = "drag_drop_step_no")
	private Integer dragAndDropArr;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

}
