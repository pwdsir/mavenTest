package com.pwd.mavenTest.interfaces.book;

import com.pwd.mavenTest.model.book.Book;
import com.pwd.mavenTest.util.page.PageData;
import com.pwd.mavenTest.util.page.PageParam;

public interface IBookService {

	/**
	 * @description 根据id查询书本信息
	 * @param id
	 * @return Book
	 * @throws Exception
	 */
	public Book getBookById(int id) throws Exception;
	
	
	/**@description 查询多个书本信息
	 * @param page
	 * @return PageData<Book>
	 * @throws Exception
	 */
	public PageData<Book> pageQueryBooks(PageParam<Book> page) throws Exception;
	
	
	/**@description 修改书本信息
	 * @param book
	 * @return boolean
	 * @throws Exception
	 */
	public boolean updateBook(Book book) throws Exception;
	
	
	/**@description 增加一个书本
	 * @param book
	 * @return boolean
	 * @throws Exception
	 */
	public boolean addBook(Book book) throws Exception;
}
