package com.mindteck.dao;

import java.util.List;

import com.mindteck.model.CartItem;

public interface CartItemDAO {
	public void addToCart(CartItem cartItem);
	public void deleteFromCart(int id);
	public void updateCart(CartItem cartItem);
	public List<CartItem> listShoppingCart();
	public CartItem getCartItemById(int id);
	public List<CartItem> getCartItemsByUsername(String username);

}
