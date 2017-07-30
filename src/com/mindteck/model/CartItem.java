package com.mindteck.model;

public class CartItem {
	private int cartId;
	private String username;
	private int productId;
	private String description;
	private int quantity;
	private double price;
	private int orderId;
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public CartItem(int cartId, int productId, String description, int quantity, double price, int orderId) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.orderId = orderId;
	}

	public CartItem() {
		
	}

}
