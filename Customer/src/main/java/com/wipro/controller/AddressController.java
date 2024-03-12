package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Address;
import com.wipro.service.AddressService;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;

	@PostMapping("/addAddress")
	public String addAddress(@RequestBody Address address) {
		Address addAddress = addressService.addAddress(address);
		return "Address added sucessfully " + addAddress;
	}

	@DeleteMapping("/deleteAddress/{id}")
	public String deleteAddress(@PathVariable("id") Long id) {
		String deleteAddress = addressService.deleteAddress(id);

		return deleteAddress;
	}

	@PutMapping("/updateAddress/{id}")
	public String updateAddress(@PathVariable("id") Long id, @RequestBody Address newAddress) {
		Address updateAddress = addressService.updateAddress(id, newAddress);
		if(updateAddress==null) {
			return "Address Not found to update";
		}
		return "Address Updated with details:> " + updateAddress;
	}

	@GetMapping("searchAddress/{id}")
	public String searchAddress(@PathVariable("id") Long id) {
		Address searchAddress = addressService.searchAddress(id);
		if (searchAddress == null) {
			return "Address with this id " + id + " doesn't exists";
		}
		return "Address Details => " + searchAddress;
	}

}
