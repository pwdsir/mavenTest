package com.pwd.mavenTest.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwd.mavenTest.dao.user.IUserDao;
import com.pwd.mavenTest.interfaces.user.IUserService;
import com.pwd.mavenTest.model.user.User;
import com.pwd.mavenTest.util.page.PageData;
import com.pwd.mavenTest.util.page.PageParam;




@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public PageData<User> pageQueryUsers(PageParam<User> page) {
		// TODO Auto-generated method stub
		List<User> list = userDao.pageQueryUsers(page);
		return new PageData<>(page.getPageNo(), page.getPageSize(), page.getDataTotal(), list);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		int effectRows = userDao.updateUser(user);
		if(effectRows>0){
			return true;
		}
		return false;
	}
	
	public boolean addUser(User user){
		userDao.addUser(user);
		if(user.getId()>0){
			return true;
		}
		return false;
	}
	
}
