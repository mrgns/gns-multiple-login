package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name = "tlms_bug_link")
public class BugLink extends TableOperation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4265875801318706722L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bug_link_id")
	private Integer linkId;

	
	@Column(name = "bug_link  ")
	private String bugLink;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "b_id ")
	private Bug bug;

}
