package com.team.java.ticketsystem.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.java.ticketsystem.entity.User;
import com.team.java.ticketsystem.service.UserService;
@RestController
public class UserController 
{
	@Autowired
	UserService userService;
	@PostMapping("/user")
	public User createUser(@RequestBody User user)
	{
		return userService.createUser(user);
	}
	@GetMapping("/users")
	public List<User> getUser()
	{
		return userService.getUser();
	}
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User obj)
	{
		return userService.updateUser(id,obj);
	}
}
