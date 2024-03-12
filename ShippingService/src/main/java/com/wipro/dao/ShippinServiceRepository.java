package com.wipro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.ShippingServiceTable;

public interface ShippinServiceRepository  extends JpaRepository<ShippingServiceTable, Long>{
	ShippingServiceTable findByCustomerId(Long customerId);
}
