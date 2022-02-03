package com.team.java.ticketsystem.entity;

//import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Admin_tb")
public class Admin 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Admin_Id",nullable=false)
	private int adminId;
	
	@Column(name="Admin_Name")
	@NotBlank(message="Admin name is mandatory")
	@Length(min=3,message="Name length should not be 0")
	@Pattern(regexp="[a-zA-Z]{3,20}",message="give valid name!")
	private String adminName;
	
	@Column(name="Admin_Password")
	@NotBlank(message="Password is required")
	@Size(min=5,message="Sorry,but given password is too short. Password must be of atleast 5 characters.")
	private String adminPassword;
	
	@Column(name="DOB")
	@Temporal(value=TemporalType.DATE)
	@Past(message="select valid date")
	private Date dateOfBirth;
	
	@Column(name="Admin_Contact")
	@Pattern(regexp="[0-9]{10}",message="give valid contact number.")
	private String adminContact;
	
	public Admin() 
	{
		super();
	}

	public Admin(int adminId, String adminName, String adminPassword, Date dateOfBirth, String adminContact) 
	{
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.dateOfBirth = dateOfBirth;
		this.adminContact = adminContact;
	}
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	@Override
	public String toString() 
	{
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", dateOfBirth=" + dateOfBirth + ", adminContact=" + adminContact + "]";
	}
	
}
