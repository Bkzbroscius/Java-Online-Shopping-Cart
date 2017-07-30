package com.mindteck.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindteck.model.User;
import com.mindteck.util.ConnectionFactory;

public class UserDAOCopy {
	private Connection connection=null;

    public UserDAOCopy() {
        connection = ConnectionFactory.getConnection();
    }
    
    /* Add user to the database after registration */
    public void addUser(User user) {
        try {
            PreparedStatement pst=connection.prepareStatement("insert into users(username, firstname,lastname, password, email) values (?, ?, ?, ?, ?)");
            // Parameters start with 1
            pst.setString(1,user.getUserid());
            pst.setString(2, user.getFirstName());
            pst.setString(3, user.getLastName());
            pst.setString(4, user.getPassword());
            pst.setString(5, user.getEmail());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /* Delete user by given id */
    public void deleteUser(String userId) {
        try {
            PreparedStatement pst = connection.prepareStatement("delete from users where username=?");
            // Parameters start with 1
            pst.setString(1, userId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void updateUser(User user) {
        try {
            PreparedStatement pst = connection.prepareStatement("update users set firstname=?, lastname=?, email=?" +" where username=?");
            // Parameters start with 1
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            //pst.setString(3, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getUserid());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /* Check if user already exists before adding user to database */
    public boolean CheckIfUserExists(String username) {
    	boolean exists =false;
    	try {
    		PreparedStatement pst = connection.prepareStatement("select * from users where username=?");
    		pst.setString(1, username);
    		ResultSet rs = pst.executeQuery();
    		exists = rs.next();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return exists;
    }
    
    /* Returns an arraylist with a list of all the users */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                User user = new User();
                user.setUserid(rs.getString("username"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    /* Given a username gets user information */
    public User getUserById(String userid) {
        User user = new User();
        try {
            PreparedStatement pst = connection.prepareStatement("select * from users where username=?");
            pst.setString(1, userid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                user.setUserid(rs.getString("username"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }    
    
    /* Checks whether login information is valid given a username and password */
    public boolean getloginInInfo(String userid, String password) {
        User user = new User();
        boolean isValid = false;
        try {
            PreparedStatement pst = connection.prepareStatement("select * from users where username=? and password=?");
            pst.setString(1, userid);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            isValid =rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }    
}

