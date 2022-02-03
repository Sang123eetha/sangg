package com.team.java.ticketsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.java.ticketsystem.entity.User;
import com.team.java.ticketsystem.repo.UserRepository;
@Service
public class UserService 
{
	@Autowired
	UserRepository userRepository;

	public User createUser(User user) 
	{
		return userRepository.save(user);
	}

	public List<User> getUser() 
	{
		return userRepository.findAll();
	}

	public User updateUser(int id, User obj) 
	{
		Optional<User> userContainer = userRepository.findById(id);
		if(userContainer.isPresent())
		{
			User oldObj = userContainer.get();
			oldObj.setUserName(obj.getUserName());
			oldObj.setPassword(obj.getPassword());
			System.out.println("Successfully Updated!!");
			return userRepository.saveAndFlush(oldObj);
		}
		System.out.println("No Object found with this id");
		return obj;
	}
}
