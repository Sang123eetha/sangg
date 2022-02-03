package com.team.java.ticketsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Ticket 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Ticket_Id",nullable=false)
	private int ticketId;
	
	@Column(name="No_of_seats",nullable=false)
	private int noOfSeats;
	
	@Column(name="seat_name",nullable=false)
	private String seatName;
	
	@Column(name="ticket_status",nullable=false)
	private boolean ticketStatus;
	
	@Column(name="screen_name",nullable=false)
	private String screenName;
	
	@OneToOne
	@JoinColumn(name="ticket_bookingRef")
	private Booking bookingRef;

	public Ticket() 
	{
		super();
	}

	public Ticket(int ticketId, int noOfSeats, String seatName, boolean ticketStatus, String screenName,
			Booking bookingRef) 
	{
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.seatName = seatName;
		this.ticketStatus = ticketStatus;
		this.screenName = screenName;
		this.bookingRef = bookingRef;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public boolean isTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Booking getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(Booking bookingRef) {
		this.bookingRef = bookingRef;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", noOfSeats=" + noOfSeats + ", seatName=" + seatName
				+ ", ticketStatus=" + ticketStatus + ", screenName=" + screenName + ", bookingRef=" + bookingRef + "]";
	}
	
}
