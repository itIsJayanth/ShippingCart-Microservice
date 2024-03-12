package com.wipro.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart implements Serializable {
	@Id
	
	private Long cartId;
	@JsonIgnoreProperties("cart")
	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
