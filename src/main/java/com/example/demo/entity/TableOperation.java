package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class TableOperation implements Serializable {

	private static final long serialVersionUID = 5441835380190287414L;

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

	@Transient
	private String reqIdSort;
	
}
