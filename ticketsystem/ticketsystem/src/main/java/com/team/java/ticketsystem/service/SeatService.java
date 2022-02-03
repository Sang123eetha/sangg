package com.team.java.ticketsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.java.ticketsystem.entity.Seat;
import com.team.java.ticketsystem.repo.SeatRepository;

@Service
public class SeatService 
{
	@Autowired
	SeatRepository seatRepository;
	
	public Seat createSeat(Seat seat)
	{
		return seatRepository.save(seat);
	}
	
	public List<Seat> getSeat()
	{
		return seatRepository.findAll();
	}
	
	public Seat updateById(int id, Seat obj) 
	{
		Optional<Seat> seatContainer = seatRepository.findById(id);
		if(seatContainer.isPresent())
		{
			Seat oldObj =  seatContainer.get();
			oldObj.setPrice(obj.getPrice());
			System.out.println("Successfully updated");
			return seatRepository.saveAndFlush(oldObj);
		}
		else
		{
			System.out.println("No object found with this Id");
			return obj;
		}
		
	}
	
	public String deleteById(int id)
	{
		Optional<Seat> seatContainer = seatRepository.findById(id);
		if(seatContainer.isPresent())
		{
			Seat oldObj =  seatContainer.get();
			seatRepository.delete(oldObj);
			return "Deleted Successfully!!";
		}
		else
		{
			return "The specified id is not present in the db";
		}
	}
}
