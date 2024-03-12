package com.wipro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ShippingServiceCustomerOrder {
	@Id
	@GeneratedValue
	private Long id;
	private Long customerId;
	private Long orderId;
	public ShippingServiceCustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShippingServiceCustomerOrder(Long customerId, Long orderId) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "ShippingServiceCustomerOrder [id=" + id + ", customerId=" + customerId + ", orderId=" + orderId + "]";
	}
	
}
