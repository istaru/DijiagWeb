package com.zll.dijiag.util.sms;

import java.text.MessageFormat;
import java.util.HashMap;
import com.alibaba.fastjson.JSONObject;
import com.xiaoleilu.hutool.http.HttpUtil;

public class SmsUtil {
	
	/**
	 * 发送短信验证码
	 * @return
	 */
	public static boolean send(String sms_appkey, String zhuceUrl, String zhuceTplId, String  zhuceTplValue, String type, String mobile, Object... values){
		boolean result = false;
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("key", sms_appkey);
		paramMap.put("mobile", mobile);
		try {
			if ( "1".equals(type) ) {
				paramMap.put("tpl_id", zhuceTplId);
				paramMap.put("tpl_value", java.net.URLEncoder.encode(MessageFormat.format(zhuceTplValue, values), "utf-8"));
				String s = HttpUtil.get(zhuceUrl, paramMap);
				if ( "0".equals(JSONObject.parseObject(s).getString("error_code")) ) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
