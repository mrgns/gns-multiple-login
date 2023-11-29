/**
 * 
 * @author Ganesh Shinde

 * @Date 20-04-2023
 * @Version 1.0
 */
package com.example.demo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tlms_bug_recording")
public class BugVideo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bug_recording_id")
	private Integer videoId;

	@Lob
	@Column(name = "recording_type")
	private byte[] recording;

	@Column(name = "recording_name")
	private String fileName;
	
	@Column(name = "file_type")
	private String filetype;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "b_id ")
	private Bug bug;
	

	@Column(name = "created_by")
	@JsonIgnore
	private Integer createdBy;

	@Column(name = "created_date")
	@JsonIgnore
	private LocalDateTime createdDate;

	@Column(name = "updated_by")
	@JsonIgnore
	private Integer updatedBy;

	@Column(name = "updated_date")
	@JsonIgnore
	private LocalDateTime updatedDate;

}
