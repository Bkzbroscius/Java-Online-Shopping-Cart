package com.mindteck.model;

import java.util.Date;

public class Order {

	// TODO Auto-generated constructor stub
	private int orderId;
	private double orderAmount;
	private String email;
	private String firstname;
	private String lastname;
	private String phone;
	private Date orderDate;
	private String orderNumber;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String i) {
		this.orderNumber = i;
	}

	public Order(int orderId, double orderAmount, String email, String firstname, String lastname, String phone,
			Date orderDate, String orderNumber) {
		super();
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.orderDate = orderDate;
		this.orderNumber = orderNumber;
	}

	public Order() {
	}

}
