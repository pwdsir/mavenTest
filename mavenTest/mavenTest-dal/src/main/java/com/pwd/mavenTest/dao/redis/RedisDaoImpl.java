package com.pwd.mavenTest.dao.redis;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDaoImpl implements IRedisDao{
	
	@Autowired
	RedisTemplate<Serializable, Serializable> redisTemplate;
	
	public void save(final String key, final Object value){
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(serializeKey(key), serializeValue(value));
				return null;
			}
		});
	}
	

	@Override
	public Object read(final String key) {
		// TODO Auto-generated method stub
		return redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyBytes = serializeKey(key);
				if (connection.exists(keyBytes)) {
					byte[] valueBytes = connection.get(keyBytes);
					return deserializeValue(valueBytes);
				}
				return null;
			}
		});
	}
	
	protected byte[] serializeKey(String key) {
		return redisTemplate.getStringSerializer().serialize(key);
	}

	@SuppressWarnings("unchecked")
	protected byte[] serializeValue(Object value) {
		RedisSerializer<Object> reidsSerializer = (RedisSerializer<Object>) redisTemplate
				.getValueSerializer();
		return reidsSerializer.serialize(value);
	}
	
	protected Object deserializeValue(byte[] value) {
		return redisTemplate.getDefaultSerializer().deserialize(value);
	}

	
}
