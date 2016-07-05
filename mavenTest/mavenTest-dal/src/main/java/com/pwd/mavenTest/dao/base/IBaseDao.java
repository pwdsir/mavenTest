package com.pwd.mavenTest.dao.base;

import java.util.List;

import com.pwd.mavenTest.util.page.PageParam;

public interface IBaseDao<T> {

	public T getById(int id);

	public List<T> pageQueryBooks(PageParam<T> page);
}
