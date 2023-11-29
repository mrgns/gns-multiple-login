package com.example.demo.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "tlms_notes")
public class Notification {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "note_id")
	private Integer noteId ;
	
	@Column(name = "bug_id")
	private String bugId;
	
	@Column(name = "staff_id")
	private Integer staffId ;
	
	@Column(name = "Created_by")
	private Integer createdBy ;
	
	@Column(name = "note_type")
	private String noteStatus;
	
	@Column(name = "action")
	private String action;
	
	@Column(name = "create_date")
	private LocalDateTime date;

}
