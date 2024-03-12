package com.wipro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShippingServiceTable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long customerId;
	private Long cartId;

	public ShippingServiceTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShippingServiceTable(Long customerId, Long cartId) {
		super();
		this.customerId = customerId;
		this.cartId = cartId;
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

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "ShippingServiceTable [id=" + id + ", customerId=" + customerId + ", cartId=" + cartId + "]";
	}

}
