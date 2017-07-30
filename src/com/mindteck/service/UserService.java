package com.mindteck.service;
import java.util.List;

import com.mindteck.model.User;

public interface UserService {
	
	public abstract boolean authenticateUser(String username, String password) throws Exception;
	public void insertUser(User user) throws Exception;
	public void removeUser(String userId) throws Exception;
	public List<User> returnAllUsers() throws Exception;
	public boolean isLoggedInOrNot(String username, String email) throws Exception;
	public User returnUserById(String username) throws Exception;

}
