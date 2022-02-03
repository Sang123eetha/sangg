package com.team.java.ticketsystem.entity;

//import java.sql.Date;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Movie 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Movie_Id")
	@NotBlank(message="Movie Id is mandatory")
	private int movieId;
	
	@Column(name="Movie_Name")
	@Length(min=3,message="Movie name length should not be 0")
	private String movieName;
	
	@OneToOne
	@JoinColumn(name="movie_genre")
	//@Column(name="Genre")
	private Show movieGenre;
	
	@Column(name="Director")
	@Length(min=3,message="length of director's name should not be 0")
	private String movieDirector;
	
	@Column(name="Movie_length")
	private int movieLength;
	
	@Column(name="Language")
	private String languages;
	
	@Column(name="Release_date")
	@Temporal(value=TemporalType.DATE)
	@FutureOrPresent(message="Select valid date")
	private Date movieReleaseDate;
	
	public Movie() 
	{
		super();
	}

	public Movie(int movieId, String movieName, Show movieGenre, String movieDirector, int movieLength,
			String languages, Date movieReleaseDate) 
	{
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieDirector = movieDirector;
		this.movieLength = movieLength;
		this.languages = languages;
		this.movieReleaseDate = movieReleaseDate;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Show getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(Show movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre
				+ ", movieDirector=" + movieDirector + ", movieLength=" + movieLength + ", languages=" + languages
				+ ", movieReleaseDate=" + movieReleaseDate + "]";
	}
	
}
