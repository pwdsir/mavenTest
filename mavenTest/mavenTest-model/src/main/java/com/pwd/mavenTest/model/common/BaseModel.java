package com.pwd.mavenTest.model.common;

public class BaseModel{

	private int pageNo=1; //第几页
	private int pageSize=10; //每页多少数据
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
			
}
