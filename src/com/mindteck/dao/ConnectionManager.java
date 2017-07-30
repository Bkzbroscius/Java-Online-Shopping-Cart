package com.mindteck.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {

	private static DataSource dataSource;

	static {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/product");
		} catch (NamingException e) {
			System.out.println(e.toString());

		}
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static void closeConnection(Connection con) {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
