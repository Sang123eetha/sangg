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

import com.team.java.ticketsystem.entity.Ticket;
import com.team.java.ticketsystem.service.TicketService;

@RestController
public class TicketController 
{
	@Autowired
	TicketService ticketService;
	@PostMapping("/ticket")
	public Ticket createTicket(@RequestBody Ticket ticket)
	{
		return ticketService.createTicket(ticket);
	}
	@GetMapping("/tickets")
	public List<Ticket> getTicket()
	{
		return ticketService.getTicket();
	}
	@PutMapping("/ticket/{id}")
	public Ticket updateById(@PathVariable int id,@RequestBody Ticket obj) 
	{
		return ticketService.updateById(id, obj);
	}
	@DeleteMapping("/ticket/{id}")
	public String deleteById(@PathVariable int id)
	{
		return ticketService.deleteById(id);
	}
}
