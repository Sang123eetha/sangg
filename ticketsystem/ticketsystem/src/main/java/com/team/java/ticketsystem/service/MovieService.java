package com.team.java.ticketsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.java.ticketsystem.entity.Movie;
import com.team.java.ticketsystem.repo.MovieRepository;

@Service
public class MovieService 
{
	@Autowired
	MovieRepository movieRepository;
	
	public Movie createMovie(Movie movie)
	{
		return movieRepository.save(movie);
	}
	
	public List<Movie> getMovie()
	{
		return movieRepository.findAll();
	}
	
	public Movie updateById(int id, Movie obj) 
	{
		Optional<Movie> movieContainer = movieRepository.findById(id);
		if(movieContainer.isPresent())
		{
			Movie oldObj =  movieContainer.get();
			oldObj.setMovieName(obj.getMovieName());
			System.out.println("Successfully updated");
			return movieRepository.saveAndFlush(oldObj);
		}
		else
		{
			System.out.println("No object found with this Id");
			return obj;
		}
		
	}
	
	public String deleteById(int id)
	{
		Optional<Movie> movieContainer = movieRepository.findById(id);
		if(movieContainer.isPresent())
		{
			Movie oldObj =  movieContainer.get();
			movieRepository.delete(oldObj);
			return "Deleted Successfully!!";
		}
		else
		{
			return "The specified id is not present in the db";
		}
	}
}
