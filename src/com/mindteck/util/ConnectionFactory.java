package com.mindteck.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionFactory {
	private static Connection connection = null;
   public static Connection getConnection() {
        if(connection != null)
            return connection;
        else {
            try {
            	
            	ResourceBundle bundle=ResourceBundle.getBundle("db");
            	String driver = bundle.getString("driver");
                String url = bundle.getString("url");
                String user = bundle.getString("user");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, "");
            } catch(Exception e) {
                e.printStackTrace();
            } 
            return connection;
        }
    }
}

