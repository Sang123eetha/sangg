package com.team.java.ticketsystem.ctrl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.java.ticketsystem.entity.Seat;
import com.team.java.ticketsystem.service.SeatService;

@RestController
public class SeatController 
{
	@Autowired
	SeatService seatService;
	@PostMapping("/seat")
	public Seat createSeat(@Valid @RequestBody Seat seat)
	{
		return seatService.createSeat(seat);
	}
	@GetMapping("/seats")
	public List<Seat> getSeat()
	{
		return seatService.getSeat();
	}
	@PutMapping("/seat/{id}")
	public Seat updateById(@PathVariable int id,@Valid @RequestBody Seat obj) 
	{
		return seatService.updateById(id, obj);
	}
	@DeleteMapping("/seat/{id}")
	public String deleteById(@PathVariable int id)
	{
		return seatService.deleteById(id);
	}
}
