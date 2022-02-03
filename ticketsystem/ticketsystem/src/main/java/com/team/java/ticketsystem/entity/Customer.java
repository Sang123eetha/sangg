package com.team.java.ticketsystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Customer_id")
	private int customerId;
	
	@Column(name="Customer_Name")
	@NotBlank(message="Customer name is mandatory")
	@Length(min=3,message="Name length should not be 0")
	@Pattern(regexp="[a-zA-Z]{3,20}")
	private String customerName;
	
	@Column(name="Password")
	@NotBlank(message="Password is required")
	@Size(min=5,message="Sorry,but given password is too short. Password must be of atleast 5 characters.")
	private String customerPassword;
	
	@Column(name="DOB")
	@Temporal(value=TemporalType.DATE)
	@Past
	private Date dateOfBirth;
	
	//@Column(name="tickets")
	@OneToMany
	@JoinColumn(name="tickets")
	private List<Ticket> myTickets;
	
	@Column(name="Contact_details")
	@Pattern(regexp="[0-9]{10}")
	private String customerContact;
	
	public Customer() 
	{
		super();
	}

	public Customer(int customerId, String customerName, String customerPassword, Date dateOfBirth,
			List<Ticket> myTickets, String customerContact) 
	{
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.dateOfBirth = dateOfBirth;
		this.myTickets = myTickets;
		this.customerContact = customerContact;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Ticket> getMyTickets() {
		return myTickets;
	}

	public void setMyTickets(List<Ticket> myTickets) {
		this.myTickets = myTickets;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", dateOfBirth=" + dateOfBirth + ", myTickets=" + myTickets + ", customerContact="
				+ customerContact + "]";
	}
}
