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
import com.mindteck.model.Order;
import com.mindteck.model.User;
import com.mindteck.util.ConnectionFactory;

public class OrderDAOImpl implements OrderDAO {
	//private Connection connection = null;

	public OrderDAOImpl() {
		/*try {
			connection = ConnectionManager.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}

	/* Insert user order into the orders table */
	public void addOrder(Order order) {
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
			System.out.println("Inside the function");
			PreparedStatement pst = connection.prepareStatement(
					"insert into orders(orderId, Orderamount, email, firstname, lastname, phone, orderDate, orderNumber) values (?, ?, ?, ?, ?, ?,?,?)");
			pst.setInt(1, order.getOrderId());
			pst.setDouble(2, order.getOrderAmount());
			pst.setString(3, order.getEmail());
			pst.setString(4, order.getFirstname());
			pst.setString(5, order.getLastname());
			pst.setString(6, order.getPhone());
			pst.setDate(7, new java.sql.Date(order.getOrderDate().getTime()));
			pst.setString(8, order.getOrderNumber());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
	}

	/* Delete a product from the cart */
	public void deleteFromCart(int id) {
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
			PreparedStatement pst = connection.prepareStatement("delete from cart where cartId=?");

			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
	}

	/* Add shopping cart items into an array and return the array */
	public List<CartItem> getCartItems(String username) {
		CartItemDAOImpl item = new CartItemDAOImpl();
		List<CartItem> li = new ArrayList<CartItem>();
		li = item.getCartItemsByUsername(username);
		return li;
	}

	/* Get user details given user's username */
	public User getUserByUsername(String username) {
		UserDAOImpl dao = new UserDAOImpl();
		User user = new User();
		user = dao.getUserById(username);
		return user;
	}

	/*
	 * When a customer places an order, the order details are added to the
	 * orders table
	 */
	public void placeOrder(Order order) {
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
			PreparedStatement pst = connection.prepareStatement(
					"insert into orders (orderId, orderAmount, email, firstname, lastname, phone, orderDate, orderNumber) values (?, ?, ?, ?, ?, ?,?, ?)");
			pst.setInt(1, order.getOrderId());
			pst.setDouble(2, order.getOrderAmount());
			pst.setString(3, order.getEmail());
			pst.setString(4, order.getFirstname());
			pst.setString(5, order.getLastname());
			pst.setString(6, order.getPhone());
			pst.setDate(7, new java.sql.Date(order.getOrderDate().getTime()));
			pst.setString(8, order.getOrderNumber());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
	}

	/* This method empties the cart after user places an order */
	public void clearCart(String username) {
		Connection connection = null;
		//Statement statement;
		try {
			connection = ConnectionManager.getConnection();
			//statement = connection.createStatement();
			PreparedStatement pst = connection.prepareStatement("delete from cartItems where username=?");
			pst.setString(1, username);
			pst.executeUpdate();
			//statement.executeUpdate("delete from cart where username=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}

	}

	/*
	 * This methods add orders from cart table to an orders arrayList and
	 * returns the ArrayList
	 */
	public List<Order> viewOrder(String username) {
		Connection connection = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			PreparedStatement pst = connection.prepareStatement("select * from cartItems where username=?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderAmount(rs.getDouble("orderAmount"));
				order.setEmail(rs.getString("email"));
				order.setFirstname(rs.getString("firstname"));//
				order.setLastname(rs.getString("lastname"));
				order.setPhone(rs.getString("phone"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setOrderNumber(rs.getString("orderNumber"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return orders;
	}

	
	/*
	 * Given an email address, this method searches the orders table for records
	 * which match the emial address and returns an orders arrayList with the
	 * records
	 */
	public List<Order> getOrderByEmail(String email) {
		Connection connection = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			connection = ConnectionManager.getConnection();
			PreparedStatement pst = connection.prepareStatement("select * from orders where email=?");
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				System.out.println("Inside while Loop");
				order.setOrderId(rs.getInt("orderId"));
				order.setEmail(rs.getString("email"));
				order.setOrderAmount(rs.getDouble("orderAmount"));
				order.setOrderNumber(rs.getString("orderNumber"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setFirstname(rs.getString("firstname"));
				order.setLastname(rs.getString("lastname"));
				orders.add(order);
				System.out.println("Inside dao email is " + order.getEmail());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return orders;
	}
}
