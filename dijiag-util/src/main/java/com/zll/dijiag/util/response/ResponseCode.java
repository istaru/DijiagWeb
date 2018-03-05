package com.zll.dijiag.util.response;

public class ResponseCode {

	/**
	 * 响应成功
	 */
	public static int CODE_SUCCESS = 0;
	
	/**
	 * 响应错误,提供错误信息(校验错误:例如必输字段为空)
	 */
	public static int CODE_ERROR = -1;

	/**
	 * 响应失败(异常响应,任何有异常抛出均为FAIL)
	 */
	public static int CODE_FAIL = 1;

}
