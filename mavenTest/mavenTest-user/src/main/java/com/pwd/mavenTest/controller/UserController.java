package com.pwd.mavenTest.controller;

import java.io.IOException;

import net.iharder.Base64;

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
	
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		String msg= "eyJjb250ZW50Ijoie1wiY3JlYXRlVGltZVwiOjE0NjQ4MjY4ODcwMDAsXCJsYXRpdHVkZVwiOjMwLjQ5MDkwOSxcInJhZGl1c1wiOjI1LFwiYmVoYXZpb3JcIjoxLFwidHlwZVwiOjIsXCJsb25naXR1ZGVcIjoxMTQuMTQ3Nzk2Mn0iLCJ0eXBlIjoxLCJ3YXRjaElkIjoiOTQxODFkNTg5MmZlNDg2YjgzZGVmZTMyNDAwODk3ZWYwMjMyMzkwNiIsInRpbWVzdGFtcCI6MTQ2NDgyNjg5MDI2Nn0=";
		byte[] b = Base64.decode(msg);
		String result = new String(b);
		System.out.println(result);
		
	}
}
