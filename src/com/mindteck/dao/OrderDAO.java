package com.mindteck.dao;

import java.util.List;

import com.mindteck.model.CartItem;
import com.mindteck.model.Order;
import com.mindteck.model.User;

public interface OrderDAO {
	public void addOrder(Order order);
	public List<CartItem> getCartItems(String username);
	public User getUserByUsername(String username);
	public void placeOrder(Order order);
	public void clearCart(String username);
	public List<Order> viewOrder(String username);
	public List<Order> getOrderByEmail(String email);

}
