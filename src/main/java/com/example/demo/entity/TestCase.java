package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Pankaj Chauhan
 * @Date 6th Aug 2022
 * @version 1.0
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tlms_test_case")
public class TestCase extends TableOperation {

	private static final long serialVersionUID = 5749228656937900690L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "case_id")
	private Integer caseId;

	@Column(name = "test_case_id")
	private String testCaseId;

	@Column(name = "test_cases")
	private String testCase;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	@JsonIgnore
	private ProjectMaster project;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rtm_id")
	@JsonIgnore
	private Rtm rtm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scenario_id")
	@JsonIgnore
	private TestScenario testScenario;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "status_id")
	private Status sheetstatus;

	@OneToMany(mappedBy = "testCase")
	@JsonIgnore
	private List<TestResult> testResult = new ArrayList<TestResult>();

	@OneToMany(mappedBy = "testCase", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TestScript> testScript = new ArrayList<TestScript>();


	@OneToMany(mappedBy = "testCase", fetch = FetchType.LAZY)
	private List<Bug> bug = new ArrayList<>();

}
