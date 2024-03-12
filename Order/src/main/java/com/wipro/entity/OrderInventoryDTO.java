package com.wipro.entity;

public class OrderInventoryDTO {
	private Long orderId;
	private Long itemId;
	private Long productId;
	private String productName;
	private int quantity;
	private double price;

	public OrderInventoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderInventoryDTO(Long orderId, Long itemId, Long productId, String productName, int quantity,
			double price) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	@Override
	public String toString() {
		return "OrderInventoryDTO [orderId=" + orderId + ", itemId=" + itemId + ", productId=" + productId
				+ ", productName=" + productName + ", quantity=" + quantity + ", price=" + price + "]";
	}

}