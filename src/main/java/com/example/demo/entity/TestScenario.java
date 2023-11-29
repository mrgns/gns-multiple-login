package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Pankaj Chauhan
 * @Date 2nd Aug 2022
 * @version 1.0
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tlms_test_scenario")
public class TestScenario extends TableOperation {

	private static final long serialVersionUID = -650238935011644912L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "scenario_id")
	private Integer scenarioId;

	@Column(name = "test_scenario_id")
	private String testScenarioId;

	@Column(name = "test_scenario_desc")
	private String testScenarioDescription;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	@JsonIgnore
	private ProjectMaster projectMaster;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rtm_id")
	@JsonIgnore
	private Rtm rtm;

	@OneToMany(mappedBy = "testScenario", fetch = FetchType.LAZY)
	@JsonManagedReference
	List<TestCase> testCase = new ArrayList<TestCase>();

	@OneToMany(mappedBy = "testScenario", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TestScript> testScript = new ArrayList<TestScript>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id")
	private Status sheetStatus;

}
