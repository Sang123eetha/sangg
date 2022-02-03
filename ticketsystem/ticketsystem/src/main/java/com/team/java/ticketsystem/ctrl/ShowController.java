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

import com.team.java.ticketsystem.entity.Show;
import com.team.java.ticketsystem.service.ShowService;

@RestController
public class ShowController 
{
	@Autowired
	ShowService showService;
	@PostMapping("/show")
	public Show createShow(@RequestBody Show show)
	{
		return showService.createShow(show);
	}
	@GetMapping("/shows")
	public List<Show> getShow()
	{
		return showService.getShow();
	}
	@PutMapping("/show/{id}")
	public Show updateById(@PathVariable int id,@RequestBody Show obj) 
	{
		return showService.updateById(id,obj);
	}
	@DeleteMapping("/show/{id}")
	public String deleteById(@PathVariable int id)
	{
		return showService.deleteById(id);
	}
}
