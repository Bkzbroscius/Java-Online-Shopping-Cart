package com.mindteck.service;

import java.util.List;

import com.mindteck.model.CartItem;
import com.mindteck.model.Order;
import com.mindteck.model.User;

public interface OrderService {
	public void insertOrderToTable(Order order);
	public List<CartItem> retrieveItemsInCart(String username);
	public User findUserByUserId(String username);
	public void orderNow(Order order);
	public void deleteAllFromCart(String username);
	public List<Order> displayOrder(String username);
	public List<Order> LinkOrderByEmail(String email);


}
