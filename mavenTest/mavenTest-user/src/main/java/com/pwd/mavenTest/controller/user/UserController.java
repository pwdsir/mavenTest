package com.pwd.mavenTest.controller.user;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pwd.mavenTest.interfaces.redis.IRedisService;
import com.pwd.mavenTest.interfaces.sms.ISmsSendService;
import com.pwd.mavenTest.interfaces.user.IUserService;
import com.pwd.mavenTest.model.common.ResultInfo;
import com.pwd.mavenTest.model.user.User;
import com.pwd.mavenTest.util.page.PageData;
import com.pwd.mavenTest.util.page.PageParam;



@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISmsSendService smsSendService;
	
	@Autowired
	private IRedisService redisService;
	
	
	private static final Logger log = LogManager.getLogger();
	
	
	
	@ResponseBody
	@RequestMapping(value="getUserById",method=RequestMethod.GET)
	public ResultInfo getUserById(){
		User user = null;
		try {
			user = userService.getUserById(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询用户信息失败", e);
		}
//		String msg = "程序有各bug";
//		boolean isSucc = smsSendService.smsSend("【pwd】赶快回来，程序出问题了。"+msg, "13556860560");
		
		redisService.save("test", "xxx");
		
		System.out.println(redisService.read("test").toString());
		return ResultInfo.success(user);
		
	}
	
	@ResponseBody
	@RequestMapping(value="getUsers",method=RequestMethod.GET)
	public ResultInfo getUsers(User user){
		
		PageParam<User> page = new PageParam<User>(user, user.getPageNo(), user.getPageSize());
		PageData<User> data = null;
		try {
			data = userService.pageQueryUsers(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询多个用户信息失败",e);
		}
		return ResultInfo.success(data);
		
	}
	
	@ResponseBody
	@RequestMapping(value="addUser",method=RequestMethod.POST)
	public ResultInfo addUser(User user){
		boolean isSucc = false;
		try {
			isSucc = userService.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("新增用户信息失败",e);
		}
		return ResultInfo.success(isSucc);
	}
	
	@ResponseBody
	@RequestMapping(value="updateUser",method=RequestMethod.POST)
	public ResultInfo updateUser(User user){
		boolean isSucc = false;
		try {
			isSucc = userService.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改用户信息失败",e);
		}
		return ResultInfo.success(isSucc);
		
	}
}
