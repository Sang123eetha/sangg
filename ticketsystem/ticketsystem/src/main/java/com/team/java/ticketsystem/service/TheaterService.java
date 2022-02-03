package com.team.java.ticketsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.java.ticketsystem.entity.Theater;
import com.team.java.ticketsystem.repo.TheaterRepository;

@Service
public class TheaterService 
{
	@Autowired
	TheaterRepository theaterRepository;
	
	public Theater createTheater(Theater theater)
	{
		return theaterRepository.save(theater);
	}
	
	public List<Theater> getTheater()
	{
		return theaterRepository.findAll();
	}
	
	public Theater updateById(int id, Theater obj) 
	{
		Optional<Theater> theaterContainer = theaterRepository.findById(id);
		if(theaterContainer.isPresent())
		{
			Theater oldObj =  theaterContainer.get();
			oldObj.setManagerName(obj.getManagerName());
			System.out.println("Successfully updated");
			return theaterRepository.saveAndFlush(oldObj);
		}
		else
		{
			System.out.println("No object found with this Id");
			return obj;
		}
		
	}
	
	public String deleteById(int id)
	{
		Optional<Theater> theaterContainer = theaterRepository.findById(id);
		if(theaterContainer.isPresent())
		{
			Theater oldObj =  theaterContainer.get();
			theaterRepository.delete(oldObj);
			return "Deleted Successfully!!";
		}
		else
		{
			return "The specified id is not present in the db";
		}
	}
}
