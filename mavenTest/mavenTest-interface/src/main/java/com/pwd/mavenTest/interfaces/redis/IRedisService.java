package com.pwd.mavenTest.interfaces.redis;

public interface IRedisService {

	public boolean save(String key,Object value);
	
	public Object read(String key);
	
	public boolean flushAll();
}
