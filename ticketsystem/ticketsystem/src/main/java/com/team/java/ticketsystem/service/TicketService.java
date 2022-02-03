package com.team.java.ticketsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.java.ticketsystem.entity.Ticket;
import com.team.java.ticketsystem.repo.TicketRepository;

@Service
public class TicketService 
{
	@Autowired
	TicketRepository ticketRepository;
	
	public Ticket createTicket(Ticket ticket)
	{
		return ticketRepository.save(ticket);
	}
	
	public List<Ticket> getTicket()
	{
		return ticketRepository.findAll();
	}
	
	public Ticket updateById(int id, Ticket obj) 
	{
		Optional<Ticket> ticketContainer = ticketRepository.findById(id);
		if(ticketContainer.isPresent())
		{
			Ticket oldObj =  ticketContainer.get();
			oldObj.setSeatName(obj.getSeatName());
			System.out.println("Successfully updated");
			return ticketRepository.saveAndFlush(oldObj);
		}
		else
		{
			System.out.println("No object found with this Id");
			return obj;
		}
		
	}
	
	public String deleteById(int id)
	{
		Optional<Ticket> ticketContainer = ticketRepository.findById(id);
		if(ticketContainer.isPresent())
		{
			Ticket oldObj =  ticketContainer.get();
			ticketRepository.delete(oldObj);
			return "Deleted Successfully!!";
		}
		else
		{
			return "The specified id is not present in the db";
		}
	}
}
