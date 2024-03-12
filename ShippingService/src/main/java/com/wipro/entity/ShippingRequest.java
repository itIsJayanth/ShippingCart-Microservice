package com.wipro.entity;

public class ShippingRequest {

	private String productName;
	private String productDescription;
	private double productPrice;
	private int quantity;

	public ShippingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShippingRequest(String productName, String productDescription, double productPrice, int quantity) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ShippingRequest [productName=" + productName + ", productDescription=" + productDescription
				+ ", productPrice=" + productPrice + ", quantity=" + quantity + "]";
	}

}
