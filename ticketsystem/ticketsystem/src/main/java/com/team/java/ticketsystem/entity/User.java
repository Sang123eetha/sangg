package com.team.java.ticketsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
@Entity
@Table(name="User_tb")
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="User_Id")
	private int userId;
	
	@Column(name="User_Name")
	@NotBlank(message="User name is mandatory")
	@Length(min=3,message="User name length should not be 0")
	private String userName;
	
	@Column(name="Password")
	@NotBlank(message="Password is required")
	@Size(min=5,message="Sorry,but given password is too short. Password must be of atleast 5 characters.")
	private String password;
	
	public User() 
	{
		super();
	}

	public User(int userId, String userName, String password) 
	{
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	

}
