package com.pwd.mavenTest.model.user;

import java.io.Serializable;
import java.util.Date;

import com.pwd.mavenTest.model.common.BaseModel;

//用户实体
public class User extends BaseModel implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String userName; //用户名
	private String userPassword; //密码
	private Date createTime; //创建时间
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPassword="
				+ userPassword + ", createTime=" + createTime + "]";
	}
	
	
}
