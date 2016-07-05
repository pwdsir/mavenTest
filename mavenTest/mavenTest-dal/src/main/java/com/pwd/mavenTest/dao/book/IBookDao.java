package com.pwd.mavenTest.dao.book;

import java.util.List;

import com.pwd.mavenTest.model.book.Book;
import com.pwd.mavenTest.util.page.PageParam;

public interface IBookDao {

	/**根据id查询书本信息
	 * @param id
	 * @return
	 */
	public Book getBookById(int id);
	
	/**查询多个书本信息
	 * @param page
	 * @return
	 */
	public List<Book> pageQueryBooks(PageParam<Book> page);
	
	/**增加一个书本
	 * @param Book
	 */
	public void addBook(Book book);
	
	/**修改书本信息
	 * @param Book
	 * @return
	 */
	public int updateBook(Book book);
}
