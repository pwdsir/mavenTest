package com.pwd.mavenTest.controller.book;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pwd.mavenTest.interfaces.book.IBookService;
import com.pwd.mavenTest.model.common.ResultInfo;
import com.pwd.mavenTest.model.book.Book;
import com.pwd.mavenTest.util.page.PageData;
import com.pwd.mavenTest.util.page.PageParam;

@Controller
@RequestMapping("book")
public class BookController {

	@Autowired
	private IBookService bookService;
	
	private static final Logger log = LogManager.getLogger();
	
	
	
	@ResponseBody
	@RequestMapping(value="getBookById",method=RequestMethod.GET)
	public ResultInfo getBookById(){
		Book book = null;
		try {
			book = bookService.getBookById(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询书本信息失败", e);
		}
		return ResultInfo.success(book);
		
	}
	
	@ResponseBody
	@RequestMapping(value="getBooks",method=RequestMethod.GET)
	public ResultInfo getBooks(Book book){
		
		PageParam<Book> page = new PageParam<Book>(book, book.getPageNo(), book.getPageSize());
		PageData<Book> data = null;
		try {
			data = bookService.pageQueryBooks(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询多个书本信息失败",e);
		}
		return ResultInfo.success(data);
		
	}
	
	@ResponseBody
	@RequestMapping(value="addBook",method=RequestMethod.POST)
	public ResultInfo addBook(Book book){
		boolean isSucc = false;
		try {
			isSucc = bookService.addBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("新增书本信息失败",e);
		}
		return ResultInfo.success(isSucc);
	}
	
	@ResponseBody
	@RequestMapping(value="updateBook",method=RequestMethod.POST)
	public ResultInfo updateBook(Book book){
		boolean isSucc = false;
		try {
			isSucc = bookService.updateBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改书本信息失败",e);
		}
		return ResultInfo.success(isSucc);
		
	}
}
