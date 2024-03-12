package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Customer;
import com.wipro.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer addCustomer = customerService.addCustomer(customer);
		return addCustomer;
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") Long id) {
		String deleteCustomer = customerService.deleteCustomer(id);
		return deleteCustomer;

	}

	@PutMapping("/updateCustomer/{id}")
	public String updateCustomer(@PathVariable("id") Long id, @RequestBody Customer newCustomer) {
		Customer updateCustomer = customerService.updateCustomer(id, newCustomer);
		if (updateCustomer == null) {
			return "Customer Not found with this ID = " + id + ", Hence Nothing Updated ";
		}
		return "Customer Updated with details:> " + updateCustomer;
	}

	@GetMapping("searchCustomer/{id}")
	public Customer searchCustomer(@PathVariable("id") Long id) {
		return customerService.searchCustomer(id);
//		if (searchCustomer == null) {
//			return "Customer with this id " + id + " doesn't exists";
//		}
//		return "Customer found with details " + searchCustomer;
	}
}
