package com.team.java.ticketsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.java.ticketsystem.entity.Customer;
import com.team.java.ticketsystem.entity.Theater;
import com.team.java.ticketsystem.repo.CustomerRepository;
import com.team.java.ticketsystem.repo.TheaterRepository;

@Service
public class CustomerService 
{
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	TheaterRepository theaterRepository;
	
	public Customer createCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	public List<Customer> getCustomer()
	{
		return customerRepository.findAll();
	}
	
	public Customer updateById(int id, Customer obj) 
	{
		Optional<Customer> customerContainer = customerRepository.findById(id);
		if(customerContainer.isPresent())
		{
			Customer oldObj =  customerContainer.get();
			oldObj.setCustomerName(obj.getCustomerName());
			System.out.println("Successfully updated");
			return customerRepository.saveAndFlush(oldObj);
		}
		else
		{
			System.out.println("No object found with this Id");
			return obj;
		}
		
	}
	
	public String deleteById(int id)
	{
		Optional<Customer> customerContainer = customerRepository.findById(id);
		if(customerContainer.isPresent())
		{
			Customer oldObj =  customerContainer.get();
			customerRepository.delete(oldObj);
			return "Deleted Successfully!!";
		}
		else
		{
			return "The specified id is not present in the db";
		}
	}
	
	public boolean chooseCity(String city)
	{
		Theater theater1 = theaterRepository.findByTheaterCity(city);
		if(null!=theater1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
