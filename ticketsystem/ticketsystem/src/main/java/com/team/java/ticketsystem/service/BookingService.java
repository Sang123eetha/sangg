package com.team.java.ticketsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.java.ticketsystem.entity.Booking;
import com.team.java.ticketsystem.repo.BookingRepository;

@Service
public class BookingService 
{
	@Autowired
	BookingRepository bookingRepository;
	
	public Booking createBooking(Booking book)
	{
		return bookingRepository.save(book);
	}
	public List<Booking> getBooking()
	{
		return bookingRepository.findAll();
	}
	public Booking updateById(int id, Booking obj) 
	{
		Optional<Booking> bookingContainer = bookingRepository.findById(id);
		if(bookingContainer.isPresent())
		{
			Booking oldObj =  bookingContainer.get();
			oldObj.setBookingDate(obj.getBookingDate());
			System.out.println("Successfully updated");
			return bookingRepository.saveAndFlush(oldObj);
		}
		else
		{
			System.out.println("No object found with this Id");
			return obj;
		}
		
	}
	public String deleteById(int id)
	{
		Optional<Booking> bookingContainer = bookingRepository.findById(id);
		if(bookingContainer.isPresent())
		{
			Booking oldObj =  bookingContainer.get();
			bookingRepository.delete(oldObj);
			return "Deleted Successfully!!";
		}
		else
		{
			return "The specified id is not present in the db";
		}
	}
}

