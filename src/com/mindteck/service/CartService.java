package com.mindteck.service;

import java.util.List;

import com.mindteck.model.CartItem;

public interface CartService {
	public void insertIntoCart(CartItem cartItem);
	public void removeFromCart(int id);
	public void changeCartItems(CartItem cartItem);
	public List<CartItem> viewCartItems();
	public CartItem getFromCartById(int id);
	public List<CartItem> listCartItemsByUsername(String username);


}
