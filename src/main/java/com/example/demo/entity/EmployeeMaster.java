package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Pankaj Chauhan
 * @Date 25th July 2022
 * @version 1.0
 */

@Entity
@Getter
@Setter
@Table(name = "employee_master")
public class EmployeeMaster implements Serializable {

	private static final long serialVersionUID = 931377982617396405L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer staffId;

	@Column(name = "Password")
	private String password;

	@Column(name = "User_Id")
	private String userID;

	@Column(name = "F_Name")
	private String firstName; // first_name

	@Column(name = "M_Name")
	private String middleName; // middle_name

	@Column(name = "L_Name")
	private String lastName;

	@Column(name = "Email_Id")
	private String emailID;

	@Column(name = "Manager_ID")
	private Integer managerID;

	@Column(name = "Emp_Job_Title")
	private String employeeJobTitle;

	@Column(name = "role")
	private String role;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleMaster> employeeRole = new ArrayList<RoleMaster>();

	@OneToMany(mappedBy = "employeeMaster", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<ProjectTeam> projectTeam = new HashSet<ProjectTeam>();

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "designation_id")
	private Designation designation;
	
	
	
}
