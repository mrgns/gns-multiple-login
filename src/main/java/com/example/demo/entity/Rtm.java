package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "tlms_rtm")
public class Rtm extends TableOperation {

	private static final long serialVersionUID = 2239226521000118301L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rtm_id")
	private Integer rtmId;

	@Column(name = "requirement_id")
	private String reqId;

	@Column(name = "requirement")
	private String requirement;

	@Column(name = "requirement_desc")
	private String requirementDesc;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	@JsonIgnore
	private ProjectMaster projectMaster;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "br_id")
	@JsonIgnore
	private BusinessRequirement brId;

	@OneToMany(mappedBy = "rtm", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<TestScenario> testScenarios = new ArrayList<TestScenario>();

	@OneToMany(mappedBy = "rtm", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TestCase> testCase = new ArrayList<TestCase>();

	@OneToMany(mappedBy = "rtm", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TestResult> testResult = new ArrayList<TestResult>();

	@OneToMany(mappedBy = "rtm", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TestScript> testScript = new ArrayList<TestScript>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id")
	private Status sheetStatus;

	@Transient
	private String newTag;

}
