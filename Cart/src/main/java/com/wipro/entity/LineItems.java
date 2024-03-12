package com.wipro.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LineItems implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	private Long productId;
	private String productName;
	private int quantity;
	private double price;
	@JsonIgnoreProperties("lineitems")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cart_cartId", nullable = false)
	private Cart cart;

	public LineItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineItems(Long productId, String productName, int quantity, double price, Cart cart) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.cart = cart;
	}

	public LineItems(Cart cart) {
		super();
		this.cart = cart;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "LineItems [itemId=" + itemId + ", productId=" + productId + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price  ;
	}

}
