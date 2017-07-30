package com.mindteck.dao;


import java.util.List;

import com.mindteck.model.User;

public interface UserDAO {

	public boolean getLoginInfo(String username, String password) throws Exception;
	public boolean checkIfUserExists(String username, String email) throws Exception;
	public void addUser(User user);
    public void deleteUser(String userId);
    public List<User> getAllUsers();
    public User getUserById(String userid);
	

}
