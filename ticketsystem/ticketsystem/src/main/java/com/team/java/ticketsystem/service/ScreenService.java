package com.team.java.ticketsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.java.ticketsystem.entity.Screen;
import com.team.java.ticketsystem.repo.ScreenRepository;

@Service
public class ScreenService 
{
	@Autowired
	ScreenRepository screenRepository;
	
	public Screen createScreen(Screen screen)
	{
		return screenRepository.save(screen);
	}
	
	public List<Screen> getScreen()
	{
		return screenRepository.findAll();
	}
	
	public Screen updateById(int id, Screen obj) 
	{
		Optional<Screen> screenContainer = screenRepository.findById(id);
		if(screenContainer.isPresent())
		{
			Screen oldObj =  screenContainer.get();
			oldObj.setScreenName(obj.getScreenName());
			System.out.println("Successfully updated");
			return screenRepository.saveAndFlush(oldObj);
		}
		else
		{
			System.out.println("No object found with this Id");
			return obj;
		}
		
	}
	
	public String deleteById(int id)
	{
		Optional<Screen> screenContainer = screenRepository.findById(id);
		if(screenContainer.isPresent())
		{
			Screen oldObj =  screenContainer.get();
			screenRepository.delete(oldObj);
			return "Deleted Successfully!!";
		}
		else
		{
			return "The specified id is not present in the db";
		}
	}
}
