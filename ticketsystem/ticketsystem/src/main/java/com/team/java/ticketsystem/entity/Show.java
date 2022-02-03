package com.team.java.ticketsystem.entity;

//import java.sql.Time;
//import java.util.*;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

@Entity
public class Show 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Show_Id",nullable=false)
	private int showId;
	
	@Column(name="Staring_Time")
	@Temporal(TemporalType.TIME)
	private Date showStartTime;
	
	@Column(name="Ending_Time")
	@Temporal(TemporalType.TIME)
	private Date showEndTime;
	
	@OneToOne
	@JoinColumn(name="show_seat")
	private Seat seats;
	
	@Column(name="Show_Name")
	@Length(min=3,message="Name length should not be 0")
	private String showName;
	
	@OneToOne
	//@Column(name="Movie_Name")
	//@Length(min=3,message="Name length should not be 0")
	@JoinColumn(name="Movie_name")
	private Movie movieName;
	
	@Column(name="Screen_Id",nullable=false)
	private int screenId;
	
	@Column(name="Theater_Id",nullable=false)
	private int theaterId;
	
	public Show() 
	{
		super();
	}

	public Show(int showId, Date showStartTime, Date showEndTime, Seat seats, String showName, Movie movieName,
			int screenId, int theaterId) {
		super();
		this.showId = showId;
		this.showStartTime = showStartTime;
		this.showEndTime = showEndTime;
		this.seats = seats;
		this.showName = showName;
		this.movieName = movieName;
		this.screenId = screenId;
		this.theaterId = theaterId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public Date getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(Date showStartTime) {
		this.showStartTime = showStartTime;
	}

	public Date getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(Date showEndTime) {
		this.showEndTime = showEndTime;
	}

	public Seat getSeats() {
		return seats;
	}

	public void setSeats(Seat seats) {
		this.seats = seats;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Movie getMovieName() {
		return movieName;
	}

	public void setMovieName(Movie movieName) {
		this.movieName = movieName;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showStartTime=" + showStartTime + ", showEndTime=" + showEndTime
				+ ", seats=" + seats + ", showName=" + showName + ", screenId=" + screenId + ", theaterId=" + theaterId
				+ "]";
	}
	
}
