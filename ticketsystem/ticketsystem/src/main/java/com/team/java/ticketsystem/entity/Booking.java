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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
@Entity
@Table(name="Booking_tb")
public class Booking 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Booking_Id")
	private int bookingId;
	
	@Column(name="Movie_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotBlank(message="Movie Id is mandatory")
	private int movieId;
	
	@Column(name="Show_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotBlank(message="Show Id is mandatory")
	private int showId;
	
	@OneToOne
	@JoinColumn(name="Book_showref")
	private Show showRef;
	
	@Column(name="Booking_date")
	@Temporal(value=TemporalType.DATE)
	@FutureOrPresent(message="Select valid date")
	private Date bookingDate;
	
	@Column(name="transaction_id")
	@NotBlank(message="Transaction Id is mandatory")
	private int transactionId;
	
	@Column(name="total_cost")
	private double totalCost;
	
	@OneToOne
	@JoinColumn(name="Book_Seat_List")
	//@Column(name="seat_list")
	private Seat seatList;
	
	@OneToOne
	private Ticket ticket;
	
	public Booking() 
	{
		super();
	}

	public Booking(int bookingId, int movieId, int showId, Show showRef, Date bookingDate, int transactionId,
			double totalCost, Seat seatList, Ticket ticket) 
	{
		super();
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.showId = showId;
		this.showRef = showRef;
		this.bookingDate = bookingDate;
		this.transactionId = transactionId;
		this.totalCost = totalCost;
		this.seatList = seatList;
		this.ticket = ticket;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public Show getShowRef() {
		return showRef;
	}

	public void setShowRef(Show showRef) {
		this.showRef = showRef;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Seat getSeatList() {
		return seatList;
	}

	public void setSeatList(Seat seatList) {
		this.seatList = seatList;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", movieId=" + movieId + ", showId=" + showId + ", showRef="
				+ showRef + ", bookingDate=" + bookingDate + ", transactionId=" + transactionId + ", totalCost="
				+ totalCost + ", seatList=" + seatList + ", ticket=" + ticket + "]";
	}
	
}
