package com.wipro.entity;

public class CartInventoryDTO {
	private Long cartId;
	private Long itemId;
	private Long productId;
	private String productName;
	private int quantity;
	private double price;
	public CartInventoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartInventoryDTO(Long cartId, Long itemId, Long productId, String productName, int quantity, double price) {
		super();
		this.cartId = cartId;
		this.itemId = itemId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
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
		return "CartInventoryDTO [cartId=" + cartId + ", itemId=" + itemId + ", productId=" + productId
				+ ", productName=" + productName + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
