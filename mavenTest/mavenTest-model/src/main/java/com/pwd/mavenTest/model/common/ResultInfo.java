package com.pwd.mavenTest.model.common;

import java.io.Serializable;

public class ResultInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4131132604020467622L;
	private int code;
	private String message;
	private Object data;
	
	public ResultInfo(int code,String message,Object data){
		this.code= code;
		this.message = message;
		this.data = data;
	}
	
	public static ResultInfo success(Object data){
		ResultInfo result = new ResultInfo(200, "成功", data);
		return result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
