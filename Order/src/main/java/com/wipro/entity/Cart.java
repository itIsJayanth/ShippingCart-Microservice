package com.wipro.entity;

import java.util.List;

public class Cart  {

	private Long cartId;

	private List<LineItems> items;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Long cartId) {
		super();
		this.cartId = cartId;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public List<LineItems> getItems() {
		return items;
	}

	public void setItems(List<LineItems> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", items=" + items + "]";
	}

}
