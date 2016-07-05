package com.pwd.mavenTest.interfaces.user;

import com.pwd.mavenTest.model.user.User;
import com.pwd.mavenTest.util.page.PageData;
import com.pwd.mavenTest.util.page.PageParam;



public interface IUserService {

	
	/**
	 * @description 根据id查询用户信息
	 * @param id
	 * @return User
	 * @throws Exception
	 */
	public User getUserById(int id) throws Exception;
	
	
	/**@description 查询多个用户信息
	 * @param page
	 * @return PageData<User>
	 * @throws Exception
	 */
	public PageData<User> pageQueryUsers(PageParam<User> page) throws Exception;
	
	
	/**@description 修改用户信息
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	public boolean updateUser(User user) throws Exception;
	
	
	/**@description 增加一个用户
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	public boolean addUser(User user) throws Exception;
}
