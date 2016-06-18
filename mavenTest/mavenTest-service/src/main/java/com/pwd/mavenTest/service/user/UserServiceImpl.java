package com.pwd.mavenTest.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwd.mavenTest.dao.user.UserDao;
import com.pwd.mavenTest.interfaces.user.IUserService;
import com.pwd.mavenTest.model.user.User;




@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}
	
}
