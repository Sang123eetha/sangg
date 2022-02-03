package com.team.java.ticketsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.java.ticketsystem.entity.Show;
@Repository
public interface ShowRepository extends JpaRepository<Show,Integer>
{

}
