package com.team.java.ticketsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.java.ticketsystem.entity.Theater;
@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer>
{
	public Theater findByTheaterCity(String theaterCity);
}
