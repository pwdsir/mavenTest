package com.pwd.mavenTest.dao.redis;

public interface IRedisDao {

	public void save(String key, Object value);

	public Object read(String key);
	
	public void flushAll();
}
