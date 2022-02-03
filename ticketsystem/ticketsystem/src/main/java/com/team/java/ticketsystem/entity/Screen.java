package com.team.java.ticketsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Screen 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Screen_Id")
	@NotBlank(message="Screen Id is mandatory")
	private int screenId;
	
	@Column(name="theater_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotBlank(message="theater Id is mandatory")
	private int theaterId;
	
	@Column(name="Screen_Name")
	private String screenName;
	
	//@Column(name="List_of_shows")
	@OneToOne
	@JoinColumn(name="Screen_Showlist")
	private Show showList;
	
	@Column(name="movie_end_date")
	@Temporal(value=TemporalType.DATE)
	private Date movieEndDate;
	
	@Pattern(regexp="[0-9]{10}",message="give valid row")
	private int rows;
	
	@Pattern(regexp="[0-9]{10}",message="give valid column")
	private int columns;
	
	public Screen()
	{
		super();
	}

	public Screen(int screenId, int theaterId, String screenName, Show showList, Date movieEndDate, int rows,
			int columns) 
	{
		super();
		this.screenId = screenId;
		this.theaterId = theaterId;
		this.screenName = screenName;
		this.showList = showList;
		this.movieEndDate = movieEndDate;
		this.rows = rows;
		this.columns = columns;
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

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Show getShowList() {
		return showList;
	}

	public void setShowList(Show showList) {
		this.showList = showList;
	}

	public Date getMovieEndDate() {
		return movieEndDate;
	}

	public void setMovieEndDate(Date movieEndDate) {
		this.movieEndDate = movieEndDate;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", theaterId=" + theaterId + ", screenName=" + screenName
				+ ", showList=" + showList + ", movieEndDate=" + movieEndDate + ", rows=" + rows + ", columns="
				+ columns + "]";
	}
}
