package com.pwd.mavenTest.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @desc 传人属性key对应的value
 * @author pengwendi
 * @date 2015-06-18
 */
public class PropertiesUtil {

	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

	private static Map<String, Object> map = new HashMap<String, Object>();

	/*
	 * 获取静态的配置文件
	 */
	public static String getPropertiesValue(String propFileName, String propertiesKey) {
		try {
			Properties properties = new Properties();
			if (null == map.get(propFileName)) {
				ClassLoader cl = Thread.currentThread().getContextClassLoader();
				InputStreamReader config = new InputStreamReader(cl.getResourceAsStream(propFileName), "UTF-8");
				properties.load(config);
				config.close();
				map.put(propFileName, properties);

				return properties.getProperty(propertiesKey);

			} else {
				properties = (Properties) map.get(propFileName);
				return properties.getProperty(propertiesKey);
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return null;

	}

	/*
	 * 获取动态的配置文件
	 */
	public static String getPropertiesChangeValue(String propFileName, String propertiesKey) {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		try {
			InputStreamReader config = new InputStreamReader(cl.getResourceAsStream(propFileName), "UTF-8");

			properties.load(config);

			config.close();
			return properties.getProperty(propertiesKey);

		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return null;

	}


}
