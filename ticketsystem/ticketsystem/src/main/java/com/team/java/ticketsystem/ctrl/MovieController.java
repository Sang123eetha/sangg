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

import com.team.java.ticketsystem.entity.Movie;
import com.team.java.ticketsystem.service.MovieService;

@RestController
public class MovieController 
{
	@Autowired
	MovieService movieService;
	@PostMapping("/movie")
	public Movie createMovie(@RequestBody Movie movie)
	{
		return movieService.createMovie(movie);
	}
	@GetMapping("/movies")
	public List<Movie> getMovie()
	{
		return movieService.getMovie();
	}
	@PutMapping("/movie/{id}")
	public Movie updateById(@PathVariable int id,@RequestBody Movie obj)
	{
		return movieService.updateById(id,obj);
	}
	@DeleteMapping("/movie/{id}")
	public String deleteById(@PathVariable int id)
	{
		return movieService.deleteById(id);
	}

}
