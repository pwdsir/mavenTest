package com.pwd.mavenTest.model.book;

import java.io.Serializable;
import java.util.Date;

import com.pwd.mavenTest.model.common.BaseModel;

//书实体
public class Book extends BaseModel implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String bookName; //书名
	private String bookAuthor; //作者名
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

	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
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
		return "Book [id=" + id + ", bookName=" + bookName + ", bookAuthor="
				+ bookAuthor + ", bookPrice=" + bookPrice + ", createTime="
				+ createTime + "]";
	}
	
}
