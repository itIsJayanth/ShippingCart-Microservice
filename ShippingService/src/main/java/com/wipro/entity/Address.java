package com.wipro.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String doorNo;
	private String streetName;
	private String layout;
	private String city;
	private int pincode;

	public Address() {
		super();
		
	}

	public Address(String doorNo, String streetName, String layout, String city, int pincode) {
		super();
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.layout = layout;
		this.city = city;
		this.pincode = pincode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", DoorNo=" + doorNo + ", streetName=" + streetName + ", Layout=" + layout
				+ ", city=" + city + ", pincode=" + pincode + "]";
	}

}
