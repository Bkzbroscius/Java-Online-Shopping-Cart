package com.mindteck.service;

import java.util.List;

import com.mindteck.dao.CartItemDAO;
import com.mindteck.dao.CartItemDAOImpl;
import com.mindteck.model.CartItem;

public class CartServiceImpl implements CartService {
	CartItemDAO dao = new CartItemDAOImpl();
	
	public void insertIntoCart(CartItem cartItem) {
		dao.addToCart(cartItem);
	}
	
	public void removeFromCart(int id) {
		dao.deleteFromCart(id);
	}
	public void changeCartItems(CartItem cartItem) {
		dao.updateCart(cartItem);
	}
	public List<CartItem> viewCartItems() {
		return dao.listShoppingCart();
	}
	public CartItem getFromCartById(int id) {
		return dao.getCartItemById(id);
	}
	
	public List<CartItem> listCartItemsByUsername(String username) {
		return dao.getCartItemsByUsername(username);
	}

}
