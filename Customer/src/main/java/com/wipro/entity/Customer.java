package com.wipro.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerName;
	private String customerEmail;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address customerBillingAddress;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id",referencedColumnName="id", insertable = false,updatable = false)
	private Address customerShippingAddress;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, String customerEmail, Address customerBillingAddress,
			Address customerShippingAddress) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerBillingAddress = customerBillingAddress;
		this.customerShippingAddress = customerShippingAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Address getCustomerBillingAddress() {
		return customerBillingAddress;
	}

	public void setCustomerBillingAddress(Address customerBillingAddress) {
		this.customerBillingAddress = customerBillingAddress;
	}

	public Address getCustomerShippingAddress() {
		return customerShippingAddress;
	}

	public void setCustomerShippingAddress(Address customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerEmail=" + customerEmail
				+ ", customerBillingAddress=" + customerBillingAddress + ", customerShippingAddress="
				+ customerShippingAddress + "]";
	}

}
