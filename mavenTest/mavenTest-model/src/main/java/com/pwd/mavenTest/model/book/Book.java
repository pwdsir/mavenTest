package com.pwd.mavenTest.model.book;

import java.io.Serializable;
import java.util.Date;

//书实体
public class Book implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String bookName; //书名
	private String authName; //作者名
	private float bookPrice; //书的价格
	private Date createTime; //创建时间
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", authName="
				+ authName + ", bookPrice=" + bookPrice + ", createTime="
				+ createTime + "]";
	}
	
	
}
