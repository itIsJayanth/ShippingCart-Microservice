package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.CartInventoryDTO;
import com.wipro.entity.Customer;
import com.wipro.entity.Inventory;
import com.wipro.entity.Orderr;
import com.wipro.entity.Product;
import com.wipro.entity.ShippingRequest;
import com.wipro.entity.ShippingServiceTable;
import com.wipro.service.ShippingServiceLayer;

@RestController
@RequestMapping("/shippingService")
public class ShippingServiceController {

	@Autowired
	ShippingServiceLayer shippingServiceLayer;

	@PostMapping("/products")
	public String performProducts(@RequestBody ShippingRequest shippingRequest) {

		return shippingServiceLayer.performProduct(shippingRequest);

	}
	@PostMapping("/customers")
	public ShippingServiceTable performCustomer(@RequestBody Customer customer) {
		return shippingServiceLayer.performCustomer(customer);
	}
	@PutMapping("/customer/cart/{customerId}")
	public String  performCustomerUpdate(@PathVariable("customerId")Long customerId,@RequestBody CartInventoryDTO cartInventoryDTO) {
		
		return shippingServiceLayer.performCustomerUpdate(customerId, cartInventoryDTO);
	}
	
	@PostMapping("/customer/order/{customerId}")
	public String performCustomerOrder(@PathVariable("customerId")Long customerId){
		return shippingServiceLayer.performCustomerOrder(customerId);
	}
	
	@GetMapping("customer/order/{customerId}")
	public Orderr performGetCustomerOrder(@PathVariable("customerId")Long customerId)
	{
		return shippingServiceLayer.performGetCustomerOrder(customerId);
	}
}
