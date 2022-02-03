package com.team.java.ticketsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.java.ticketsystem.entity.Show;
import com.team.java.ticketsystem.repo.ShowRepository;

@Service
public class ShowService 
{
	@Autowired
	ShowRepository showRepository;
	
	public Show createShow(Show show)
	{
		return showRepository.save(show);
	}
	
	public List<Show> getShow()
	{
		return showRepository.findAll();
	}
	
	public Show updateById(int id, Show obj) 
	{
		Optional<Show> showContainer = showRepository.findById(id);
		if(showContainer.isPresent())
		{
			Show oldObj =  showContainer.get();
			oldObj.setShowName(obj.getShowName());
			System.out.println("Successfully updated");
			return showRepository.saveAndFlush(oldObj);
		}
		else
		{
			System.out.println("No object found with this Id");
			return obj;
		}
		
	}
	
	public String deleteById(int id)
	{
		Optional<Show> showContainer = showRepository.findById(id);
		if(showContainer.isPresent())
		{
			Show oldObj =  showContainer.get();
			showRepository.delete(oldObj);
			return "Deleted Successfully!!";
		}
		else
		{
			return "The specified id is not present in the db";
		}
	}
	
}
