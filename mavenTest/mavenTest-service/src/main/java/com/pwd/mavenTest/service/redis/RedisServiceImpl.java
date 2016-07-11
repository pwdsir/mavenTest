package com.pwd.mavenTest.service.redis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwd.mavenTest.dao.redis.RedisDaoImpl;
import com.pwd.mavenTest.interfaces.redis.IRedisService;

@Service("redisService")
public class RedisServiceImpl implements IRedisService{

	@Autowired
	private RedisDaoImpl redisDao;
	
	private static final Logger log = LogManager.getLogger();
	
	@Override
	public boolean save(String key, Object value) {
		// TODO Auto-generated method stub
		try {
			redisDao.save(key, value);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("redis错误save===>",e);
			return false;
		}
		
	}

	@Override
	public Object read(String key) {
		// TODO Auto-generated method stub
		try {
			return redisDao.read(key);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("redis错误read================>",e);
			return null;
		}
		
	}

	@Override
	public boolean flushAll() {
		// TODO Auto-generated method stub
		try {
			redisDao.flushAll();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			log.error("redis错误flushAll================>",e);
			return false;
		}
	}

}
