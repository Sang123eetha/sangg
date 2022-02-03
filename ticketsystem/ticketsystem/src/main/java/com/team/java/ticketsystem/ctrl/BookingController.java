package com.team.java.ticketsystem.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.java.ticketsystem.entity.Booking;
import com.team.java.ticketsystem.service.BookingService;

@RestController
public class BookingController 
{
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/booking")
	public Booking createBooking(@RequestBody Booking book)
	{
		return bookingService.createBooking(book);
	}
	@GetMapping("/bookings")
	public List<Booking> getBooking()
	{
		return bookingService.getBooking();
	}
	@PutMapping("/booking/{id}")
	public Booking updateById(@PathVariable int id,@RequestBody Booking obj) 
	{
		return bookingService.updateById(id,obj);
	}
	@DeleteMapping("/booking/{id}")
	public String deleteById(@PathVariable int id)
	{
		return bookingService.deleteById(id);
	}
}
