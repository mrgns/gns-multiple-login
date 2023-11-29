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
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Dhanashri Kad
 * @Date 1st Aug 2022
 * @Modified Date 6 Sept 2022
 * @version 1.0
 */
@Setter
@Getter
@Entity
@Table(name = "tlms_bug")
public class Bug extends TableOperation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1263593619650192737L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_id")
	private int id;

	@Column(name = "bug_id")
	private String bugId;

	@Column(name = "description")
	private String description;

	@Column(name = "defect_area")
	private String defectArea;

	@Column(name = "status_by_tester")
	private String statusByTester;

	@Column(name = "reopen_date")
	private String reopenDate;

	@Column(name = "tester_comment")
	private String testerComment;

	@Column(name = "status_by_developer")
	private String statusByDeveloper;

	@Column(name = "resolved_date")
	private String resolvedDate;

	@Column(name = "developer_comment")
	private String developerComment;

	@Column(name = "assigned_date")
	private String assignedDate;

	@Column(name = "closed_date")
	private String closedDate;

	@Column(name = "test_round")
	private int testRound;

	@Column(name = "priority")
	private String priority;
	
	
	@Column(name = "severity")
	private String severity;
	
	@Transient
	private String AssignedBy;
	
	@Transient
	private String AssignedTo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "project_id")
	private ProjectMaster projectMaster;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "project_team_id")
	private ProjectTeam projectTeam;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "staff_id")
	private EmployeeMaster employeeMaster;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "case_id")
	private TestCase testCase;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "rtm_id")
	private Rtm rtm;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "scenario_id")
	private TestScenario testScenario  ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "test_script_id")
	private TestScript testScript;
	
	//TestResult foreign key mapping
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "test_result_id")
	private TestResult testResult;
	
	@OneToMany(mappedBy = "bug", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<BugImage> bugImage = new ArrayList<>();


	@OneToMany(mappedBy = "bug", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BugLink> bugLink = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "bug", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BugVideo> bugVideo = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "priority_id")
	private BugPriority bugPriority;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "severity_id")
	private BugSeverity bugSeverity;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "defect_type_id")
	private BugDefectType bugDefectType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "sts_by_tstr_id")
	private  StatusByTester  statByTester;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "sts_by_dev_id")
	private  StatusByDeveloper statByDeveloper;

	@Transient
	private String newTag;
	
	@Column(name = "open_seen")
	private Integer openSeen;
	
	@Column(name = "reopen_seen")
	private Integer reopenSeen;
	
	@Column(name = "close_seen")
	private Integer closeSeen;
	
	@Column(name = "resolve_seen")
	private Integer resolveSeen;

	@Column(name = "ba_open_seen")
	private Integer baOpenSeen;
	
	@Column(name = "ba_close_seen")
	private Integer baClosedSeen;
	
	@Column(name = "pm_open_seen")
	private Integer pmOpenSeen;
	
	@Column(name = "pm_close_seen")
	private Integer pmClosedSeen;
}