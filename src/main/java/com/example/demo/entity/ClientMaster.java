package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ClientMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7577387556508671977L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Customer_ID")
	private Integer customerID;

	@Column(name = "Company_Name")
	private String companyName;

	@Column(name = "customer_code")
	private String customerCode;

	@Column(name = "Domain_Name")
	private String domainName;

	@Column(name = "Office_Contact_Number")
	private String officeContactNumber;

	@Column(name = "Contact_Person_Name")
	private String contactPersonName;

	@Column(name = "Contact_Person_Number")
	private String contactPersonNumber;

	@Column(name = "Contact_Person_Mobile_Number")
	private String contactPersonMobileNumber;

	@Column(name = "Email_Id")
	private String emailId;

	@Column(name = "Website")
	private String website;

	@Column(name = "location_id")
	private Integer locationId;

	@Column(name = "Start_Date")
	private Date startDate;

	@Column(name = "Technology")
	private String technology;

	@Column(name = "MSA_Signed")
	private char MSASigned;

	@Column(name = "NDA_Signed")
	private char NDASigned;

	@Column(name = "Customer_Status")
	private char customerStatus;

	@Column(name = "Address")
	private String address;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "account_no")
	private String accountNo;

	@Column(name = "GSTIN")
	private String GSTIN;

	@Column(name = "PAN")
	private String PAN;

	@Column(name = "internal_notes")
	private String internalNotes;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "deleted_by")
	private String deletedBy;

	@Column(name = "deleted_date")
	private Date deletedDate;

	@Column(name = "aws_img_url")
	private String awsImgUrl;

	@OneToMany(mappedBy = "clientmaster", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProjectMaster> projectMaster;

}
