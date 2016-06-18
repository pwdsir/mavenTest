package com.pwd.mavenTest.dao.user;

import java.util.List;

import com.pwd.mavenTest.model.user.User;




public interface UserDao{ 
	public User getUserById(int id);
	
	public List<User> getUsers(User user);
	
	public int addUser(User user);
	
	public int updateUser(User user);
	
}
