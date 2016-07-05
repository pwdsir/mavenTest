package com.pwd.mavenTest.service.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwd.mavenTest.dao.book.IBookDao;
import com.pwd.mavenTest.interfaces.book.IBookService;
import com.pwd.mavenTest.model.book.Book;
import com.pwd.mavenTest.util.page.PageData;
import com.pwd.mavenTest.util.page.PageParam;

@Service("bookService")
public class BookServceImpl implements IBookService{

	@Autowired
	private IBookDao bookDao;
	

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(id);
	}

	@Override
	public PageData<Book> pageQueryBooks(PageParam<Book> page) {
		// TODO Auto-generated method stub
		List<Book> list = bookDao.pageQueryBooks(page);
		return new PageData<>(page.getPageNo(), page.getPageSize(), page.getDataTotal(), list);
	}

	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		int effectRows = bookDao.updateBook(book);
		if(effectRows>0){
			return true;
		}
		return false;
	}
	
	public boolean addBook(Book book){
		bookDao.addBook(book);
		if(book.getId()>0){
			return true;
		}
		return false;
	}
	
}
