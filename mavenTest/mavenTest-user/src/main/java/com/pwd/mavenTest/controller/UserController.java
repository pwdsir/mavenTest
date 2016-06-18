package com.pwd.mavenTest.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pwd.mavenTest.interfaces.user.IUserService;
import com.pwd.mavenTest.model.ResultInfo;
import com.pwd.mavenTest.model.user.User;



@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	
	
	@ResponseBody
	@RequestMapping(value="get",method=RequestMethod.GET)
	public ResultInfo helloWord(){
		User user = userService.getUserById(1);
		return ResultInfo.success(user);
		
	}
	
}
