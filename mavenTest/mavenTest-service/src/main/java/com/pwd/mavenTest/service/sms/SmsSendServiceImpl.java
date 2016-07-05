package com.pwd.mavenTest.service.sms;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pwd.mavenTest.common.PropertiesUtil;
import com.pwd.mavenTest.interfaces.sms.ISmsSendService;
import com.pwd.mavenTest.model.common.Constants;
import com.pwd.mavenTest.util.sms.SmsApi;

@Service("smsSendService")
public class SmsSendServiceImpl implements ISmsSendService {

	private static final Logger log = LogManager.getLogger();

	@Override
	public boolean smsSend(String text, String mobile) {
		// TODO Auto-generated method stub
		String apikey = PropertiesUtil.getPropertiesValue(
				Constants.MAVEN_USER_PROPERTIES, Constants.YUNPIAN_API_KEY);
		try {
			String json = SmsApi.sendSms(apikey, text, mobile);
			JSONObject jsonObject = JSONObject.parseObject(json);
			String code = jsonObject.get("code").toString();
			if ("0".equals(code)) {
				return true;
			}
			log.error("短信发送失败===>"+jsonObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("短信发送失败", e);
		}
		return false;
	}

}
