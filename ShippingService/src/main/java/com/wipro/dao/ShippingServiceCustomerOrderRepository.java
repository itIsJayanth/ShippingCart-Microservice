package com.wipro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.ShippingServiceCustomerOrder;

public interface ShippingServiceCustomerOrderRepository extends JpaRepository<ShippingServiceCustomerOrder, Long> {
	public ShippingServiceCustomerOrder findByCustomerId(Long customerId);

}
