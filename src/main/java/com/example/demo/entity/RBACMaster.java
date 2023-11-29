package com.example.demo.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Rupesh Gawas
 * @Date 20-07-2023
 * @Version 1.0
 */


@Entity(name="rbac_master")
@Getter
@Setter
public class RBACMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -457061716178121820L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rbac_id")
	private int rbacId;
	
	@Column(name = "role_id")
	private String roleId;
	
	@Column(name = "read_access")
	private String readAccess;
	
	@Column(name = "write_access")
	private String writeAccess;
	
	@Column(name = "edit_access")
	private String editAccess;
	
	@Column(name = "delete_access")
	private String deleteAccess;
	
	@Column(name = "use_case_id")
	private String useCaseId;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(name = "updated_date")
	private String updatedDate;
	
	@Column(name = "deleted_by")
	private String deletedBy;
	
	@Column(name = "deleted_date")
	private String deletedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "use_case_id",insertable = false, updatable = false )
	private UseCase useCase;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "role_id",insertable = false, updatable = false )
	private RoleMaster roleMaster;
	
}
