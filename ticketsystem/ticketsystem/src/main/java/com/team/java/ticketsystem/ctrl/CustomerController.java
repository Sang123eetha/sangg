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

import com.team.java.ticketsystem.entity.Customer;
import com.team.java.ticketsystem.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	CustomerService customerService;
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer)
	{
		return customerService.createCustomer(customer);
	}
	@GetMapping("/customers")
	public List<Customer> getCustomer()
	{
		return customerService.getCustomer();
	}
	@PutMapping("/customer/{id}")
	public Customer updateById(@PathVariable int id,@RequestBody Customer obj) 
	{
		return customerService.updateById(id,obj);
	}
	@DeleteMapping("/customer/{id}")
	public String deleteById(@PathVariable int id)
	{
		return customerService.deleteById(id);
	}
	@GetMapping("/customers/{city}")
	public String checkCity(@PathVariable String city)
	{
		if(customerService.chooseCity(city))
		{
			return "City is available.";
		}
		else
		{
			return "City is not available!!!";
		}
		
	}
}
