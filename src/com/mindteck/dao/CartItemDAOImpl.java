package com.mindteck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.dao.ConnectionManager;
import com.mindteck.model.CartItem;
import com.mindteck.util.ConnectionFactory;
import com.mindteck.model.Order;

public class CartItemDAOImpl implements CartItemDAO {
	//private Connection connection = null;

	public CartItemDAOImpl() {
		/* try {
			connection = ConnectionManager.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/* This methods inserts products into the shopping cart */
	public void addToCart(CartItem cartItem) {
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
			System.out.println("Inside the function");
			PreparedStatement pst = connection.prepareStatement(
					"insert into cartItems(id, username, description,quantity, price, orderId) values (?, ?, ?, ?,?,?)");
			
			pst.setInt(1, cartItem.getProductId());
			pst.setString(2, cartItem.getUsername());
			pst.setString(3, cartItem.getDescription());
			pst.setInt(4, cartItem.getQuantity());
			pst.setDouble(5, cartItem.getPrice());
			pst.setInt(6, cartItem.getOrderId());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
	
	}
	
	/* delete from the cart a product with a given id */
	public void deleteFromCart(int id) {
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
			PreparedStatement pst = connection.prepareStatement("delete from cartItems where cartId=?");

			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
	}

	

	public void updateCart(CartItem cartItem) {
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
			PreparedStatement pst = connection.prepareStatement("update cartItems set price=?, quantity=?" + " where id=?");

			pst.setDouble(1, cartItem.getPrice());
			pst.setInt(2, cartItem.getQuantity());
			pst.setInt(3, cartItem.getCartId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
	}

	/* add cart items from database to an arrayList and return the arrayList */
	public List<CartItem> listShoppingCart() {
		Connection connection = null;
		List<CartItem> cartItems = new ArrayList<CartItem>();
		try {
			connection = ConnectionManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from cartItems");
			while (rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("id"));
				cartItem.setDescription(rs.getString("description"));
				cartItem.setPrice(rs.getDouble("price"));
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setOrderId(rs.getInt("orderId"));
				cartItems.add(cartItem);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return cartItems;
	} 

	public List<CartItem> getCartItemsByUsername(String username) {
		Connection connection = null;
	
		List<CartItem> cartItems = new ArrayList<CartItem>();
		try {
			connection = ConnectionManager.getConnection();
			PreparedStatement pst = connection.prepareStatement("select * from cartItems where username=?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("id"));
				cartItem.setDescription(rs.getString("description"));
				cartItem.setPrice(rs.getDouble("price"));
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setOrderId(rs.getInt("orderId"));
				cartItems.add(cartItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return cartItems;
	}
	/* This method returns a cart item with a given id */
	public CartItem getCartItemById(int id) {
		Connection connection = null;
		CartItem cartItem = new CartItem();
		try {
			connection = ConnectionManager.getConnection();
			PreparedStatement pst = connection.prepareStatement("select * from cartItems where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setDescription(rs.getString("description"));
				cartItem.setPrice(rs.getDouble("price"));
				cartItem.setQuantity(rs.getInt("quantity"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return cartItem;
	}
}
