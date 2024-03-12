package com.wipro.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


public class Orderr  {
	
	private Long orderId;
	@JsonIgnoreProperties("orderr")
	@OneToMany(mappedBy = "orderr", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LineItems> items;

	public Orderr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orderr(Long orderId) {
		super();
		this.orderId = orderId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	 @JsonManagedReference
	public List<LineItems> getItems() {
		return items;
	}

	public void setItems(List<LineItems> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Orderr [OrderId=" + orderId + ", items=" + items + "]";
	}

}
