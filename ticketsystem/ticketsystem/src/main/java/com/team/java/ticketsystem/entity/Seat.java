package com.team.java.ticketsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Seat 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotBlank(message="seat Id is mandatory")
	@Column(name="Seat_Id",nullable=false)
	private int seatId;
	
	@Enumerated(EnumType.STRING)
	//@Column(name="Status",nullable=false)
	private BookingState seatStatus;
	
	@Column(name="Price",nullable=false)
	private double price;
	
	public Seat() 
	{
		super();
	}

	public Seat(int seatId, BookingState seatStatus, double price) 
	{
		super();
		this.seatId = seatId;
		this.seatStatus = seatStatus;
		this.price = price;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public BookingState getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(BookingState seatStatus) {
		this.seatStatus = seatStatus;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatStatus=" + seatStatus + ", price=" + price + "]";
	}

}
