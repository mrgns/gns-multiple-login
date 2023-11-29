package com.example.demo.entity;


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
@Setter
@Getter
@Table(name = "tlms_bug_img")
public class BugImage extends TableOperation {

	private static final long serialVersionUID = -5927475061367027903L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bug_img_id")
	private Integer imgId;

	@Lob
	@Column(name = "bug_image")
	private byte[] image;

	@Column(name = "image_file")
	private String fileName;
	
	@Column(name = "file_type")
	private String filetype;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "b_id ")
	private Bug bug;

	
}
