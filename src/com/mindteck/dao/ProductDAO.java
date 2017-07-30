package com.mindteck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.model.Product;
import com.mindteck.util.ConnectionFactory;

public class ProductDAO {

	public ProductDAO() {
		// connection = ConnectionFactory.getConnection();
	}

	/* Add a product to the cart */
	public void addProduct(Product product) {
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
			PreparedStatement pst = connection
					.prepareStatement("insert into products(description,price,quantity) values (?, ?, ?)");
			pst.setString(1, product.getDescription());
			pst.setDouble(2, product.getPrice());
			pst.setInt(3, product.getQuantity());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
	}

	public void deleteProduct(int id) {
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
			PreparedStatement pst = connection.prepareStatement("delete from products where id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
	}
    /* Change product price and quantity */
	public void updateProduct(Product product) {
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
			PreparedStatement pst = connection.prepareStatement("update Products set price=?, quantity=?" + " where id=?");

			pst.setDouble(1, product.getPrice());
			pst.setInt(2, product.getQuantity());
			pst.setInt(3, product.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
	}

	/* List all the products */
	public List<Product> getAllProducts() {
		Connection connection = null;
		List<Product> products = new ArrayList<Product>();
		try {
			connection = ConnectionManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from products");
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setQuantity(rs.getInt("quantity"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(connection);
		}
		return products;
	}

	/* Return a product given an id */
	public Product getProductById(int id) {
		Connection connection = null;
		Product product = new Product();
		try {
			connection = ConnectionManager.getConnection();
			PreparedStatement pst = connection.prepareStatement("select * from product where prod_ID=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				product.setId(rs.getInt("prod_ID"));
				product.setDescription(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setQuantity(rs.getInt("quantity"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			ConnectionManager.closeConnection(connection);
		}
		return product;
	}
}
