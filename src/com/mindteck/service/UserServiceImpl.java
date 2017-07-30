package com.mindteck.service;

import java.util.List;

import com.mindteck.dao.UserDAO;
import com.mindteck.dao.UserDAOImpl;
import com.mindteck.model.User;

public class UserServiceImpl implements UserService {
	
	UserDAO udao = new UserDAOImpl();
	
	public boolean authenticateUser(String username, String password) throws Exception {
		return udao.getLoginInfo(username, password);
	}
	

	public void insertUser(User user) throws Exception{
		 udao.addUser(user);
		
	}
	public void removeUser(String userId)throws Exception {
		udao.deleteUser(userId);
		
	}
	public List<User> returnAllUsers() throws Exception {
		return udao.getAllUsers();
		
	}
	public boolean isLoggedInOrNot(String username, String email) throws Exception{
		 return udao.checkIfUserExists(username, email);
	}
	
	public User returnUserById(String username) throws Exception {
		return udao.getUserById(username);
	}
}
