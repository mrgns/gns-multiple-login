package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

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
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="tlms_buss_reqmt")
public class BusinessRequirement extends TableOperation{
	
	private static final long serialVersionUID = 2239226521000118301L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "br_id")
	private Integer brId;
	
	@Column(name = "bus_reqmt_id")
	private String brIdString;
	
	@Column(name = "br_name")
	private String brName;
	
	@Column(name = "br_desc")
	private String brDescription;
	
	@Transient
	 private String newTag;
	
	
	@Transient
	private Integer brNo;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	@JsonIgnore
	private ProjectMaster projectMaster;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "brId")
	@JsonManagedReference
	private List<Rtm> rtm = new ArrayList<Rtm>();
	
}
