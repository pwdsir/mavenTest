package com.pwd.mavenTest.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwd.mavenTest.dao.redis.RedisDaoImpl;
import com.pwd.mavenTest.interfaces.redis.IRedisService;

@Service("redisService")
public class RedisServiceImpl implements IRedisService{

	@Autowired
	private RedisDaoImpl redisDao;
	
	@Override
	public void save(String key, Object value) {
		// TODO Auto-generated method stub
		redisDao.save(key, value);
	}

	@Override
	public Object read(String key) {
		// TODO Auto-generated method stub
		return redisDao.read(key);
	}

}
