package com.wipro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.entity.Customer;

@FeignClient("clientCustomer")
public interface CustomerProxy {

	@PostMapping("/customer/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) ;

	@DeleteMapping("/customer/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") Long id) ;
	

	@PutMapping("/customer/updateCustomer/{id}")
	public String updateCustomer(@PathVariable("id") Long id, @RequestBody Customer newCustomer) ;

	@GetMapping("/customer/searchCustomer/{id}")
	public Customer searchCustomer(@PathVariable("id") Long id);
}
