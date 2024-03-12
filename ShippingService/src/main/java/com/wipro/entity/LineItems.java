package com.wipro.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


public class LineItems {
	@Id
	private Long itemId;
	private Long productId;
	private String productName;
	private int quantity;
	private double price;
	@JsonIgnoreProperties("lineitems")
	@ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
	@JoinColumn(name = "orderr_orderId", nullable = false)
	private Orderr orderr;

	public LineItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineItems(Long itemId, Long productId, String productName, int quantity, double price, Orderr orderr) {
		super();
		this.itemId = itemId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.orderr = orderr;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@JsonBackReference
	public Orderr getOrder() {
		return orderr;
	}

	public void setOrder(Orderr orderr) {
		this.orderr = orderr;
	}

	@Override
	public String toString() {
		return "LineItems [itemId=" + itemId + ", productId=" + productId + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price;
	}

}
