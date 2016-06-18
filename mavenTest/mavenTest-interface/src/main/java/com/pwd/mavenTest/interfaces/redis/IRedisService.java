package com.pwd.mavenTest.interfaces.redis;

public interface IRedisService {

	public void save(String key,Object value);
	
	public Object read(String key);
}
