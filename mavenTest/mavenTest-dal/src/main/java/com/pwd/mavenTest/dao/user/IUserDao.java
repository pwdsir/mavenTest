package com.pwd.mavenTest.dao.user;

import java.util.List;

import com.pwd.mavenTest.model.user.User;
import com.pwd.mavenTest.util.page.PageParam;




public interface IUserDao{ 
	
	/**根据id查询用户信息
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
	
	/**查询多个用户信息
	 * @param page
	 * @return
	 */
	public List<User> pageQueryUsers(PageParam<User> page);
	
	/**增加一个用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**修改用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
}
