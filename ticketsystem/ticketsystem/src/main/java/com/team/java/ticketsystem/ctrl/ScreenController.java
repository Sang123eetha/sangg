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

import com.team.java.ticketsystem.entity.Screen;
import com.team.java.ticketsystem.service.ScreenService;

@RestController
public class ScreenController 
{
	@Autowired
	ScreenService screenService;
	@PostMapping("/screen")
	public Screen createScreen(@RequestBody Screen screen)
	{
		return screenService.createScreen(screen);
	}
	@GetMapping("/screens")
	public List<Screen> getScreen()
	{
		return screenService.getScreen();
	}
	@PutMapping("/screen/{id}")
	public Screen updateById(@PathVariable int id,@RequestBody Screen obj) 
	{
		return screenService.updateById(id, obj);
	}
	@DeleteMapping("/screen/{id}")
	public String deleteById(@PathVariable int id)
	{
		return screenService.deleteById(id);
	}
}
