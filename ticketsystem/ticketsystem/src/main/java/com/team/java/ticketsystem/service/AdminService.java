package com.team.java.ticketsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.java.ticketsystem.entity.Admin;
import com.team.java.ticketsystem.repo.AdminRepository;
@Service
public class AdminService 
{
	@Autowired
	AdminRepository adminRepository;
	
	public Admin createAdmin(Admin adm)
	{
		return adminRepository.save(adm);
	}
	
	public List<Admin> getAdmin()
	{
		return adminRepository.findAll();
	}
	
	public Admin updateById(int id, Admin obj) 
	{
		Optional<Admin> adminContainer = adminRepository.findById(id);
		if(adminContainer.isPresent())
		{
			Admin oldObj =  adminContainer.get();
			oldObj.setAdminName(obj.getAdminName());
			System.out.println("Successfully updated");
			return adminRepository.saveAndFlush(oldObj);
		}
		else
		{
			System.out.println("No object found with this Id");
			return obj;
		}
		
	}
	
	public String deleteById(int id)
	{
		Optional<Admin> adminContainer = adminRepository.findById(id);
		if(adminContainer.isPresent())
		{
			Admin oldObj =  adminContainer.get();
			adminRepository.delete(oldObj);
			return "Deleted Successfully!!";
		}
		else
		{
			return "The specified id is not present in the db";
		}
	}
}
