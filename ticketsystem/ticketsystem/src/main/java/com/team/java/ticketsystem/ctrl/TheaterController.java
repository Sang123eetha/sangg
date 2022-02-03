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

import com.team.java.ticketsystem.entity.Theater;
import com.team.java.ticketsystem.service.TheaterService;

@RestController
public class TheaterController 
{
	@Autowired
	TheaterService theaterService;
	@PostMapping("/theater")
	public Theater createTheater(@RequestBody Theater theater)
	{
		return theaterService.createTheater(theater);
	}
	@GetMapping("/theaters")
	public List<Theater> getTheater()
	{
		return theaterService.getTheater();
	}
	@PutMapping("/theater/{id}")
	public Theater updateById(@PathVariable int id,@RequestBody Theater obj) 
	{
		return theaterService.updateById(id, obj);
	}
	@DeleteMapping("/theater/{id}")
	public String deleteById(@PathVariable int id)
	{
		return theaterService.deleteById(id);
	}
}
