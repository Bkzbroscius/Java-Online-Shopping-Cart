package com.mindteck.service;

import java.util.List;

import com.mindteck.dao.OrderDAO;
import com.mindteck.dao.OrderDAOImpl;
import com.mindteck.model.CartItem;
import com.mindteck.model.Order;
import com.mindteck.model.User;

public class OrderServiceImpl implements OrderService {
	OrderDAO dao = new OrderDAOImpl();
	public void insertOrderToTable(Order order) {
		dao.addOrder(order);
		
	}
	public List<CartItem> retrieveItemsInCart(String username) {
		return dao.getCartItems(username);
		
	}
	public User findUserByUserId(String username) {
		return dao.getUserByUsername(username);
		
	}
	public void orderNow(Order order) {
		dao.placeOrder(order);
		
	}
	public void deleteAllFromCart(String username) {
		dao.clearCart(username);
		
	}
	public List<Order> displayOrder(String username) {
		return dao.viewOrder(username);
		
	}
	public List<Order> LinkOrderByEmail(String email) {
		return dao.getOrderByEmail(email);
		
	}

}
