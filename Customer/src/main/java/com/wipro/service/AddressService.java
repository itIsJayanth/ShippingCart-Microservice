package com.wipro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dao.AccountRepository;
import com.wipro.entity.Address;

@Service
public class AddressService {
	@Autowired
	private AccountRepository accountRepository;

	public Address addAddress(Address address) {

		return accountRepository.save(address);
	}

	public String deleteAddress(Long id) {
		Optional<Address> findById = accountRepository.findById(id);
		if (findById.isEmpty()) {
			return "Address Doesn't exists ";
		} else {
			Address address = findById.get();
			Long id2 = address.getId();
			System.out.println("address id one is " + id);
			System.out.println("address id two is " + id2);
			accountRepository.deleteById(id);
			accountRepository.deleteById(id2 + 1);
			return "Address Deleted";
		}
	}

	public Address updateAddress(long id, Address newAddress) {
		Optional<Address> findById = accountRepository.findById(id);
		if (findById.isEmpty()) {
			return null;

		} else {
			Address address = findById.get();

			address.setCity(newAddress.getCity());
			address.setDoorNo(newAddress.getDoorNo());
			address.setLayout(newAddress.getLayout());

			address.setPincode(newAddress.getPincode());
			address.setStreetName(newAddress.getStreetName());
			return accountRepository.save(address);

		}
	}

	public Address searchAddress(Long id) {
		Optional<Address> findById = accountRepository.findById(id);

		if (findById.isEmpty()) {
			return null;
		}
		Address address = findById.get();
		return address;
	}
}
