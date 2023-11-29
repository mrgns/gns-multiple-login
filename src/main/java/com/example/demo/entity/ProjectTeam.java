package com.example.demo.entity;

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

/**
 * @author Pankaj Chauhan
 * @Date 1st Aug 2022
 * @version 1.0
 */

@Entity
@Getter
@Setter
@Table(name = "project_team")
public class ProjectTeam extends TableOperation{

	private static final long serialVersionUID = 7578845806317523609L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_team_ID")
	private Integer projectTeamId;

	@ManyToOne
	@JoinColumn(name = "staff_id")
	private EmployeeMaster employeeMaster;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private ProjectMaster projectMaster;

	@OneToOne(mappedBy = "projectTeam", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private TestResult testResult;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private RoleMaster roleMaster;

}
