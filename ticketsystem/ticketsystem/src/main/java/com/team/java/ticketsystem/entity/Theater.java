package com.team.java.ticketsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
public class Theater 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Theater_Id",nullable=false)
	private int theaterId;
	
	@Column(name="Theater_name",nullable=false)
	@NotBlank(message="Theater name is mandatory")
	@Length(min=3,message="Theater length should not be 0")
	private String theaterName;
	
	@Column(name="Theater_city",nullable=false)
	@NotBlank(message="City name is mandatory")
	private String theaterCity;
	
	@OneToOne
	@JoinColumn(name="theater_movie")
	private Movie movie;
	
	@OneToOne
	@JoinColumn(name="theater_listScreen")
	private Screen listOfScreens;
	
	@Column(name="Manager_Name",nullable=false)
	@Length(min=3,message="Name length should not be 0")
	@NotBlank(message="Manager name is mandatory")
	private String managerName;
	
	@Column(name="Contact",nullable=false)
	@Pattern(regexp="[0-9]{10}")
	private String managerContact;
	
	public Theater() 
	{
		super();
	}

	public Theater(int theaterId, String theaterName, String theaterCity, Movie movie, Screen listOfScreens,
			String managerName, String managerContact) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.movie = movie;
		this.listOfScreens = listOfScreens;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterCity() {
		return theaterCity;
	}

	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Screen getListOfScreens() {
		return listOfScreens;
	}

	public void setListOfScreens(Screen listOfScreens) {
		this.listOfScreens = listOfScreens;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

	@Override
	public String toString() {
		return "Theater [theaterId=" + theaterId + ", theaterName=" + theaterName + ", theaterCity=" + theaterCity
				+ ", movie=" + movie + ", managerName=" + managerName + ", managerContact=" + managerContact + "]";
	}
	
}
