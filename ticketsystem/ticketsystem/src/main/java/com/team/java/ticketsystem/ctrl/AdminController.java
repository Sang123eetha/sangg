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

import com.team.java.ticketsystem.entity.Admin;
import com.team.java.ticketsystem.service.AdminService;
@RestController
public class AdminController 
{
	@Autowired
	AdminService adminService;
	@PostMapping("/admin")
	public Admin createAdmin(@RequestBody Admin adm)
	{
		return adminService.createAdmin(adm);
	}
	@GetMapping("/admins")
	public List<Admin> getAdmin()
	{
		return adminService.getAdmin();
	}
	@PutMapping("/admin/{id}")
	public Admin updateById(@PathVariable int id,@RequestBody Admin obj) 
	{
		return adminService.updateById(id,obj);
	}
	@DeleteMapping("/admin/{id}")
	public String deleteById(@PathVariable int id)
	{
		return adminService.deleteById(id);
	}
}


