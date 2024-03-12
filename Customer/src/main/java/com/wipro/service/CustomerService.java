package com.wipro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dao.AccountRepository;
import com.wipro.dao.CustomerRepository;
import com.wipro.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AccountRepository accountRepository;

	public Customer addCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	public String deleteCustomer(Long id) {
		Optional<Customer> findById = customerRepository.findById(id);
		if (findById.isEmpty()) {
			return "No Customer Found With this ID = " + id + " to delete";
		}

		else {
			Customer customer = findById.get();
			Long id2 = customer.getCustomerShippingAddress().getId();
			System.out.println("customer id is " + id);
			System.out.println("shiping address " + id2);
			customerRepository.deleteById(id);
			accountRepository.deleteById(id2 + 1);
			return "Customer deleted With this ID = " + id;
		}
	}

	public Customer updateCustomer(long id, Customer newCustomer) {
		Optional<Customer> findById = customerRepository.findById(id);

		if (findById.isEmpty()) {
			System.out.println("Customer Doesn't exists");
			return null;
		} else {
			Customer customer = findById.get();
			customer.setCustomerName(newCustomer.getCustomerName());
			customer.setCustomerEmail(newCustomer.getCustomerEmail());
			customer.setCustomerBillingAddress(newCustomer.getCustomerBillingAddress());
			customer.setCustomerShippingAddress(newCustomer.getCustomerShippingAddress());
			return customerRepository.save(customer);

		}

	}

	public Customer searchCustomer(Long id) {
		Optional<Customer> findById = customerRepository.findById(id);
		if (findById.isEmpty()) {
			return null;
		} else {
			Customer customer = findById.get();
			return customer;
		}
	}
}
